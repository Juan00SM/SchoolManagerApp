package com.juansm.schoolmanager;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.juansm.schoolmanager.Model.DAOs.StudentDAO;
import com.juansm.schoolmanager.Model.Database.DataBaseConnection;
import com.juansm.schoolmanager.Model.Entities.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class StudentDAOInstrumentedTest {

    private StudentDAO studentDAO;
    private static Student studentFull, studentWithoutID, studentWithID;

    @Before
    public void setUp() throws Exception {
        InstrumentationRegistry.getInstrumentation().getTargetContext()
                .deleteDatabase(DataBaseConnection.DATABASE_NAME);
        DataBaseConnection.setContext(InstrumentationRegistry.getInstrumentation().getTargetContext());
        studentDAO = StudentDAO.getInstance();

        this.studentFull = new Student(null, "Angel", "Robles", (long) 6, "09/11/1998", "roberto@rober.es",
                "698123456", "Calle Feria nº17", null, null, "Fernando", "957876878",
                "Maria", "789765734");

        this.studentWithoutID = new Student();
        this.studentWithoutID.setName("Rafael");
        this.studentWithoutID.setLastName("Rodriguez");
        this.studentWithoutID.setBirthDate("12/12/2010");
        this.studentWithoutID.setPhone("768956478");
        this.studentWithoutID.setEmail("rafa@gmail.com");

        this.studentWithID = new Student();
        this.studentWithID.setId((long) 22);
        this.studentWithID.setName("Rafael");
        this.studentWithID.setLastName("Rodriguez");
        this.studentWithID.setBirthDate("12/12/2010");
        this.studentWithID.setPhone("768956478");
        this.studentWithID.setEmail("rafa@gmail.com");
    }

    @Test
    public void StudentCRUD() {
        /**
         * CP-StudentDAO-01
         * Insertar Student
         */
        Long id;
        id = this.studentDAO.insertStudent(null);
        assertEquals(new Long(-1), id);

        id = this.studentDAO.insertStudent(new Student());
        assertEquals(new Long(-1), id);

        id = this.studentDAO.insertStudent(this.studentFull);
        this.studentFull.setId(id);
        assertNotEquals(new Long(-1), id);


        /**
         * CP-StudentDAO-02
         * Modificar Student
         */

        assertFalse(this.studentDAO.modifyStudent(null));

        assertFalse(this.studentDAO.modifyStudent(this.studentWithoutID));

        assertTrue(this.studentDAO.modifyStudent(this.studentFull));


        /**
         * CP-StudentDAO-04
         * Leer students reducidos
         */
        //dentro de la base de datos ya hay 11 mas el añadido ahora son 12
        assertEquals(12,this.studentDAO.getStudentsReduced().size());

        Student st1 = new Student(),st2 = new Student();
        st1.setName("PEPE");st1.setPhone("698345678");
        st2.setName("FRANCISCO");st2.setPhone("675456123");
        this.studentDAO.insertStudent(st1);
        this.studentDAO.insertStudent(st2);

        //Ahora seran 14
        assertEquals(14,this.studentDAO.getStudentsReduced().size());


        /**
         * CP-StudentDAO-05
         * Leer students por el id
         */
        assertNull(this.studentDAO.getStudentById(null));
        assertNull(this.studentDAO.getStudentById((long)200));
        assertTrue(this.studentFull.equals(this.studentDAO.getStudentById(this.studentFull.getId())));


        /**
         * CP-StudentDAO-06
         * Leer students por consulta
         */
        //ya hay 14 en la base de datos, por los de por defecto
        assertEquals(14,this.studentDAO.getStudentsByCriteriaReduced(null,null,null).size());

        assertEquals(1,this.studentDAO.getStudentsByCriteriaReduced("pe",null,null).size());

        assertEquals(6,this.studentDAO.getStudentsByCriteriaReduced("an",null,null).size());
        assertEquals(1,this.studentDAO.getStudentsByCriteriaReduced("an","09/11/1998",null).size());
        assertEquals(0,this.studentDAO.getStudentsByCriteriaReduced("an","09/11/1998",(long)2).size());

        //698123456, 698345678, 675456123
        assertEquals(3,this.studentDAO.getStudentsByCriteriaReduced("698",null,null).size());
        assertEquals(1,this.studentDAO.getStudentsByCriteriaReduced("698","09/11/1998",null).size());
        assertEquals(1,this.studentDAO.getStudentsByCriteriaReduced("698",null,(long)6).size());

        assertEquals(2,this.studentDAO.getStudentsByCriteriaReduced("123",null,null).size());
        assertEquals(0,this.studentDAO.getStudentsByCriteriaReduced("111",null,null).size());


        /**
         * CP-StudentDAO-03
         * Eliminar un Student por su id
         */
        assertFalse(this.studentDAO.removeStudent(null));

        assertFalse(this.studentDAO.removeStudent(this.studentWithID.getId()));

        assertTrue(this.studentDAO.removeStudent(this.studentFull.getId()));
    }

}