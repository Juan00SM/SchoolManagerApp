package com.juansm.schoolmanager;

import com.juansm.schoolmanager.Model.Entities.Student;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student studentTest;

    @Before
    public void setUp() throws Exception {

        this.studentTest = new Student();

    }

    @Test
    public void getId() {
        Student st = new Student();
        assertNull(st.getId());

        st.setId((long) -1);
        assertNull(st.getId());

        st.setId((long) 0);
        assertEquals(new Long(0), st.getId());

        st.setId((long) 1);
        assertEquals(new Long(1), st.getId());

        st.setId((long) 2);
        assertEquals(new Long(2), st.getId());
    }

    @Test
    public void setId() {
        assertFalse(this.studentTest.setId(null));
        assertFalse(this.studentTest.setId((long) -1));

        assertTrue(this.studentTest.setId((long) 0));
        assertTrue(this.studentTest.setId((long) 1));
        assertTrue(this.studentTest.setId((long) 2));
    }

    @Test
    public void getName() {
        Student st = new Student();
        assertNull(st.getName());

        st.setName("Jua87n");
        assertNull(st.getName());

        st.setName("Jua-n_");
        assertNull(st.getName());

        st.setName("Juan");
        assertEquals("Juan", st.getName());

        st.setName("juan");
        assertEquals("juan", st.getName());

        st.setName("JUAN");
        assertEquals("JUAN", st.getName());
    }

    @Test
    public void setName() {
        assertFalse(this.studentTest.setName(null));
        assertFalse(this.studentTest.setName("Jua87n"));
        assertFalse(this.studentTest.setName("Jua-n_"));

        assertTrue(this.studentTest.setName("Juan"));
        assertTrue(this.studentTest.setName("juan"));
        assertTrue(this.studentTest.setName("JUAN"));
    }


    @Test
    public void getLastName() {
        Student st = new Student();
        assertNull(st.getLastName());

        st.setLastName("Sanc93z");
        assertNull(st.getLastName());

        st.setLastName("S*n-h_ez");
        assertNull(st.getLastName());

        st.setLastName("sanchez");
        assertEquals("sanchez", st.getLastName());

        st.setLastName("Sanchez");
        assertEquals("Sanchez", st.getLastName());

        st.setLastName("SANCHEZ");
        assertEquals("SANCHEZ", st.getLastName());
    }

    @Test
    public void setLastName() {
        assertFalse(this.studentTest.setLastName(null));
        assertFalse(this.studentTest.setLastName("Sanc93z"));
        assertFalse(this.studentTest.setLastName("S*n-h_ez"));

        assertTrue(this.studentTest.setLastName("sanchez"));
        assertTrue(this.studentTest.setLastName("Sanchez"));
        assertTrue(this.studentTest.setLastName("SANCHEZ"));
    }


    @Test
    public void getIdGender() {
        Student st = new Student();
        assertNull(st.getIdGender());

        st.setIdGender((long) -1);
        assertNull(st.getIdGender());

        st.setIdGender((long) 0);
        assertEquals(new Long(0), st.getIdGender());

        st.setIdGender((long) 1);
        assertEquals(new Long(1), st.getIdGender());

        st.setIdGender((long) 2);
        assertEquals(new Long(2), st.getIdGender());
    }

    @Test
    public void setIdGender() {
        assertFalse(this.studentTest.setIdGender(null));
        assertFalse(this.studentTest.setIdGender((long) -1));

        assertTrue(this.studentTest.setIdGender((long) 0));
        assertTrue(this.studentTest.setIdGender((long) 1));
        assertTrue(this.studentTest.setIdGender((long) 2));
    }

    @Test
    public void getBirthDate() {
        Student st = new Student();
        assertNull(st.getBirthDate());

        st.setBirthDate("2000/12/12");
        assertNull(st.getBirthDate());

        st.setBirthDate("12-12-2000");
        assertNull(st.getBirthDate());

        st.setBirthDate("6/3/2000");
        assertNull(st.getBirthDate());

        st.setBirthDate("06/03/00");
        assertNull(st.getBirthDate());

        st.setBirthDate("30/02/2000");
        assertNull(st.getBirthDate());

        st.setBirthDate("12/12/2000");
        assertEquals("12/12/2000", st.getBirthDate());

        st.setBirthDate("06/03/2000");
        assertEquals("06/03/2000", st.getBirthDate());

        st.setBirthDate("29/02/2000");
        assertEquals("29/02/2000", st.getBirthDate());
    }

    @Test
    public void setBirthDate() {
        assertFalse(this.studentTest.setBirthDate(null));
        assertFalse(this.studentTest.setBirthDate("2000/12/12"));
        assertFalse(this.studentTest.setBirthDate("12-12-2000"));
        assertFalse(this.studentTest.setBirthDate("6/3/2000"));
        assertFalse(this.studentTest.setBirthDate("06/03/00"));
        assertFalse(this.studentTest.setBirthDate("30/02/2000"));

        assertTrue(this.studentTest.setBirthDate("12/12/2000"));
        assertTrue(this.studentTest.setBirthDate("29/02/2000"));
        assertTrue(this.studentTest.setBirthDate("06/03/2000"));
    }

    @Test
    public void getEmail() {
        Student st = new Student();

        assertNull(st.getEmail());

        st.setEmail("juan@juan.");
        assertNull(st.getEmail());

        st.setEmail("Juan-juan.com");
        assertNull(st.getEmail());

        st.setEmail("juan@juan.com");
        assertEquals("juan@juan.com", st.getEmail());

        st.setEmail("juanjuan@ju.es");
        assertEquals("juanjuan@ju.es", st.getEmail());

        st.setEmail("mertrus@gtruyh.wer");
        assertEquals("mertrus@gtruyh.wer", st.getEmail());
    }

    @Test
    public void setEmail() {
        assertFalse(this.studentTest.setEmail(null));
        assertFalse(this.studentTest.setEmail("juan@juan."));
        assertFalse(this.studentTest.setEmail("Juan-juan.com"));

        assertTrue(this.studentTest.setEmail("juan@juan.com"));
        assertTrue(this.studentTest.setEmail("juanjuan@ju.es"));
        assertTrue(this.studentTest.setEmail("mertrus@gtruyh.wer"));
    }

    @Test
    public void getPhone() {
        Student st = new Student();

        assertNull(st.getPhone());

        st.setPhone("567567765");
        assertNull(st.getPhone());

        st.setPhone("9578989");
        assertNull(st.getPhone());

        st.setPhone("67867867");
        assertNull(st.getPhone());

        st.setPhone("698517827");
        assertEquals("698517827", st.getPhone());

        st.setPhone("798675634");
        assertEquals("798675634", st.getPhone());

        st.setPhone("957786787");
        assertEquals("957786787", st.getPhone());
    }

    @Test
    public void setPhone() {
        assertFalse(this.studentTest.setPhone(null));
        assertFalse(this.studentTest.setPhone("567567765"));
        assertFalse(this.studentTest.setPhone("9578989"));
        assertFalse(this.studentTest.setPhone("67867867"));

        assertTrue(this.studentTest.setPhone("698517827"));
        assertTrue(this.studentTest.setPhone("798675634"));
        assertTrue(this.studentTest.setPhone("957786787"));
    }


    @Test
    public void getAddress() {
        Student st = new Student();

        assertNull(st.getAddress());

        st.setAddress("Calle feria 1*");
        assertNull(st.getAddress());

        st.setAddress("Ronda sur 3-1-1@");
        assertNull(st.getAddress());


        st.setAddress("Calle feria 16");
        assertEquals("Calle feria 16", st.getAddress());

        st.setAddress("c/feria 16");
        assertEquals("c/feria 16", st.getAddress());

        st.setAddress("Ronda sur 3º");
        assertEquals("Ronda sur 3º", st.getAddress());
    }

    @Test
    public void setAddress() {
        assertFalse(this.studentTest.setAddress(null));
        assertFalse(this.studentTest.setAddress("Calle feria 1*"));
        assertFalse(this.studentTest.setAddress("Ronda sur 3-1-1@"));

        assertTrue(this.studentTest.setAddress("Calle feria 16"));
        assertTrue(this.studentTest.setAddress("c/feria 16"));
        assertTrue(this.studentTest.setAddress("Ronda sur 3º"));
    }

    @Test
    public void getImg() {
        Student st = new Student();
        assertNull(st.getImg());

        String img = "/9j/4AAQSkZJRgABAQEAYABgAAD//gA7Q1JFQVRPUjogZ2QtanBlZyB2MS4wICh1c2luZyBJSkcgSlBFRyB2NjIpLCBxdWFsaXR5ID0gODIK/9sAQwAGBAQFBAQGBQUFBgYGBwkOCQkICAkSDQ0KDhUSFhYVEhQUFxohHBcYHxkUFB0nHR8iIyUlJRYcKSwoJCshJCUk/9sAQwEGBgYJCAkRCQkRJBgUGCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQk/8AAEQgBbAEsAwEiAAIRAQMRAf/EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/aAAwDAQACEQMRAD8AsDml2+9Cjilr7g+ADAoxiijtQAYpMClAzS7fegBAOtFKBzTsUAM5pQDTsUoHtSuAzFGPapNvtRs9qLgR49qXZUgSlxigaRFso2VKR7Um2lqDI9lGypce1KBmjURD5dLsxU+2jZRqPlRBto2+1T7KNtGocqINtIUzU+2kI9qNRNWIdntRs+lS7aNtMaRDt9qNtSleOlJtouK5HijGKft9qNvtRcLkdFOx7UuPancBlIBUhFNoATFFAooATbTW60+mOOaaJlsPpOlIOtO7Uig70oGKFpwGaAADPNGM0oFKFpA0IF4pduO9PxxRjNA7DQKcBShcHpTsUhpDdtLtzTgtPApXGR7aUrUgUntTgntSuBDijbVgIPSjaPSi47EG2lCVNsHpS+X7UrhYgCZpfLNTBKXZTuNQuQeWaNlTlaTYKLg42ICnNIUqfYKCo9KLisVyvNNZassvtTGXii4NEOyk21LjFJjmquIixSbc08rz0oPSi5PKRgUhWn4ApMUxNWI2FIBxTyKQigLDNtJ0p9NIpgNPWmN1qT1phpomWw8YzR3pBTlFIoUD0pwFApyikUkFOC5oC+1OAxQFgApcYNAFOA71LYwApwXNAHNSKBikAgUelLtGelRSXcUPGdzegqpJqrZ+UKv60WbKNMJinBaxv7WmJ4YfkKmj1dweQp/SnysEzU20uyq0OqQSYDZQ+p6VcUq4yrAg+lQ7otNDAtO207FKBkUmMZsFLsp+KMUhke2mleamx3pCBTTERFaQpUu2jbRcCAr601lqSSSOIZdwKpyanCp+VWb9KpaktomKimleaptq6/8APMfnUiajC/3gRVcrRF09iVlppX1p6ukgyrA0pFIRFjFNYVKRTGFVcCPFNIqXHFMIpk7DD0pppxFNPNMQ31pjdR9KeaaR600KWw7tSjPakpwGOlIY4c1IBxTFFJ5uLhIAMlkZ856YIH9f0qWxx1JhSjrQue9Pxmk2UAHNPCjFKqginAYpXGkJgAZPbvWdeX5zsjPy+vrT9RutuYlPHesaaYgZzVJdWNK46a5PrVV7n3qzpGh6p4mvRaaZbPO5+8eioPVj2r1DQ/gVZxosmt30lxJ3itztQe2Tyf0rGvjKVDSb17HfQwVSrrFHkYugDyakS6B6GvoW2+GXhK2TauiwP7yFmP6mi5+GfhK5Qq2jQpxgGNmQ/oa4v7Ypdmdn9jztujwKK5HrV+01F4GyrZHcHoa9F1n4H2kil9F1CW3ftHcfOp/Ecj9a851vw7rHhefydTs3jBOFlHKP9D/k12UcZRr6Rf3nDXwNSlrJG/Z3kV2vynDd1q0EFcdbXTRsHQ7WBrqdNv1vY8HAdRyPX3q5xsc0HrZlnaKCgp4B7UuDWVzSxGVFN21KR7U1yqKWY4AGSTTDQibCqSxxjnJrJvdX25SE/wDAj/Sq+p6qZ3KR5EY7Z61a0PwPr3iXbJbW/k2zf8t5vlX8O5/AVbcaa5qjsZxjKo+WCuYst2WOWbJqs9z6GvXNN+CemxgHUr+5uXxysWI1z+prYX4SeEgCDp8pzxk3D/41zSzWhF2Vzvp5VVkjwc3fvTkus4617NqHwR8O3QP2OW8s2xxiTeo/A8/rXAeJ/hNr/h1WuLcLqNovJeAfOo906/lmtKOY0Kjtez8wq5bVpq9rmJBdEEEEg/Wta1uVnG1uH/nXKwT/ADY71pW8+CCDg12tXPNnBo3iKaRmm20vnxg/xd6kIrIgiNNp7CmnpTQEZFNOMU81GaoltDD1pCfWlINRuTmqRMnoSDtUgqOpF6CpY2PAqGMt/aMw2YAhjw2euWf/AAFT9qpQO39uXiE/KLWBgPffN/gKib2Nqa3fkaQqRVzTQKkUcUiVuOUYps8nkxM/cdKkAFUNWl2qqfiaErsp6IybqYliSateFPC134x1dbODKQJhp5u0a/4nsKzJd80ixRKXkdgqqBnJPavoXwP4Xi8LaDBaYH2lwJLhx/E5H8h0rDHYr2EPd3Z34HDKrK72NHQNAsPDlillp9usUS8k9Wc+rHua0zSDpS18tKTk7s+pgklZBSUtJUlC5qvfWFrqdtJa3kEdxDIMMjjINT0tO9gavozw7x78Np/DhfUdLDzacTlkPLQfX1X37d/WuTsbt4JVdCQwr6amjSaNo5FDKwIKkcEV4L8QvB58K6n9otFP9nXLfJ/0ybrt/wAK+gy/HOp+6q79z53MsCofvKexo2dyt3AsinnuPQ1Ng1zOg6h5E4Rz+7fg+x7GuqxXZOPKzzYu5EVzWDq15JczrZ2gaQltuEGS59BWlrV59jtSqf6yThfb3rtPh14KTS7VNW1CLN9MN0aMP9Qp/wDZj+lZVa8aMOd79DWhRdefKtupW8G/DCCzSO+12JZ7k4ZLc8pH/vf3j+n1r0NVCgAAAAYAHailrwatWdWXNNn0FKjGnHlghw60uaavWn1zM7YbBSEZHNFFIo82+JHwxh1SOXV9FiEV8o3SwqMLP7gf3v5143A7I5RshgcEHtX1aea8S+L/AIRXSdTj1uzjK214xEwUcJL1z7bhz9Qa9zK8Y7+xm/Q8XM8GuV1YfM5jT5/LkGT14Na5XNc3aSAgEHNdFA/mQI3qK9ma6nzzVnYYw5qNqnZaiYYqSSLFVbiUpcW8akDzGORjqAp/rirfNZjuZNdVB0t7YluO8jgD/wBFt+dEnZIqMU7vsWz2qN/vVITzj0qN+taowlsPHQVIopg7VKtSy0PWsyVvJ8TQDjN1ZSDPqY3U/wApDWmKyPEjfY5tK1Htb3ipIfRJQYz/AOPMh/Csqrsk+xvRXM3HumvwOgC8U9RSAcYqQD5aYktRQP1rE1eTNww9ABW6o4rnNVb/AEiT6mqhqxT6I2/hboy6x4villXdFYqbgjHVgQFz+Jz+Fe9jivMPgdYqLDU78j5pJlhB9lGf/Zq9Or57MKjnXa7aH0eBp8tFeY4GnDpTQO9OHSvOZ6VMWkozRnmpNRaKSloARulYfiXRrfXdMnsLkfJKuM91PYj3BrcPFVLgVrSbTujnxK5oWZ82T21xpWoTWVyNk0DlGHqR3/rXZaPeC7sFdj8yfKx/rT/i5oy2uoWmsRLgXAMMuP746H8R/KuX0/UHgtp4kyfNUKPY5/wzX1NOft6Sn1PlK9P2VR2Oz8FaIfE3iN7+4UGxsWBUHo7dh/WvWsYrE8HaINA0C2tNuJWXzJT6uev5dPwrcr5/FVva1G+i2PfwlH2VNLq9wAzS+1AGKcPWuRs7YRAdKKMijPNQbhRRRQAVjeMNFXxB4bvrAjLvGWjPo45X9RWzQeacZOLUl0FKKkmmfK9sdpweCDiuk0x99vj0NZ3ieyGm+LNUtFGFS4cqP9knI/Q1d0bmJ/qK+z5uaCl3PiaseWpYtkVEw5qdhxUL1JkyE8nnpWLo7m6vtWvMcG4Fuh9VjUA/+PF61NRvE0+xuLyQ4S3jaVvoBms/w3aSWWh2kc2fOZPNlz13udzfqxqXrNI0WlJvvoXm5qNutSNUT9a3RzT2JUqRRUaVKopMavbQetVta0z+19JvbAtg3MRVT/dbHyn8Dg1aA4zUycrWcldNM1g+WSl21KHhnUzrGh2l5J8szJsmXusqna4/76BrWUVzWnD+xvFV3ppGLXUwb63PYSjAlUfX5W/OuoXpWVKV42e6OirFKd1s9UOA4Fcvqw/0iX/eNdUo7VzWtrsuZR75ram9TGfQ9Y+DMZTwg7HB33UhH5KP6V3lef8AwVnEnhS4jycx3jjB91U13+eK+axf8efqfT4b+FG3YeBS9BSKcmlNcbO2mtBKO9FUtU1W00WxkvtQnS3t4xlnfj/JpFl2ivE/EPx3v5pnh8NaWxjBI8+WMuzf8BHA/HNcZc/Grxpb3GZ9RkhbOQrW6KPy21N1sM+nyciqlweDXh/hz9oTUI5Ej1i1hu4j1kiHlyD+h/SvXtG8Rad4m09b7TJxNEeCOjIfQjsa0p7mFfYxviFpg1TwjfLj57cC4Qj1Xr+ma8w8B2P9p+IdOt2XKGbe3+6g3H+Ve3XNut5aXNs4+WaJ0P0KkV5r8HdPA1qeRwC1vbkD2ZmH9Aa9jDVnChUXb9dDxa1Lnq0/X8j2DHFCruOKbPNHbQtNNIsccalmdjgKB1JNcSPibDqd7JbaPDugGQt5LwJGB5CL3HXk/lXh1KsYK8j3fZnfrEoFMkTbyvSuFfV9YuG4vpwT2QAfoBVHW/F3iPw9YPcIq3pBG2GdOW555GD0rlhjKbdjQ9ForjfBPxL0vxmvkJm01BB89rIeT6lT3/mK6/dXYlfYnmHg9qdTRyKUdKCxaY7bRmlJxVaeTjApxV2RUnyq54L8RAo8caiQAMlCff5BTNFX92/pxSePZRN411HH8Lqv4hRUukR4ty3qa+tpaUYryPjsS26rZabvUTCpmGTUbcGrRi1bc5jxgTcpYaOvLajcqjj/AKZJ88n6KB/wKteV1hjLMQqoMk9gKyLUf2p4vvr08waXGLKL0MrYeQ/UDYv4Gp/EFwYobO3H3rm8hj+oD72H/fKsKyhL4p/1obThrGkv6v8A8AvMOahfrU0h5z64qF+tdS2OGZKlTLUKVMtJmiIUm2ar5JP+tg3KP91uf/QxWig4rn/EVx/Zp0/VekdrOEn9opPkJ/AlW/CuhSsE9WjeUdIyMzxJpU+paestjtXUbOQXNqx6GRR90+zDKn61oaLqsGtaZBfwZCTLkq3VG6FT7g5B+lWV4rCKDw3rhm+7pmqSDzPSC5PAb2V+n+8B61nP3Zc3Rm0Fzw5Oq2/yOkUd6wvEUOJt395RW+nORjGKz9ctzLahwMlDWsHqYSV1dHRfA6+Czatp7HkhJlHr1B/pXrIGQK+efAOrDQvGdjO7bYZ2NvJ9G4/ng/hX0QOeleHmUOWu5dGfRZfNTpJdgHBoJpQMGkPWvMe56cVZE6KFX9a898SOvi28azlQSWKsUSM9HI6t/hXa6pcmHSrqVCQ6RMRjsccVwdrdRWBSeZgscfXNcWLqSVoR6jSuQf8ACJaRpds6yqVjiHLbtuB9BxXzn8YdTnsNbhhiG2wlUvAT95sHB3e44/OvbvGXiu1v5HjguohbphpDvAHsDXzL8XvF1pr+r21tp8yzQWSsDKp+V3bGcH0GBW1KmorQoNI1Q3E6RliM+lepeBPFV54P1aG9jdprVyEnizjcn+Poa8O8KeZNfA8kKM16npZyoVuVPBrXYXLdWZ9c2U8V2kc8LiSKVQ6MOjKRkGuJ+EqINV1xVP3SiqPbc3/1qtfDK+ZvAVvPOxItY5UJ/wBlCcfpj8qy/g9cg67qkJxuliWTH0b/AOyr06fvUKj8l+Z5D92vTi+7Mv45+OJPt8HhWymMUWUN26nG4tjCfQDk/UelcbceK9H0FER7uOERgBBuwRiuT+ImoS6j4i1S7ZjvkuZGz6fMcfpivLNckld3dmZmPUk5rx6lFVGnLoeu2fW3gn4maXqWnNcrKJ/3hTzAh4wBwcfWumbVdL1yNo2uYm3jGxvlP4CvirwP8RLvwZNNGYPtVnOQzxbtpDDjKnsa6vWPje+oWT2ulafJaySgqZ5XBKA+gHf3o9jHYDvPE8reH/EFrqenzmKYPyycYdejfj3+lfRHgnxNH4r8O22pgBZWGyZB0Vx1/ofxr4n0zWLy9SKK4uJJUQ5UO2cfjX0l+z5qDvZ6pZs2VUxygehIIP8AIVtSjy+6Zz2uezK3PrT81XVs0/fgdatrUUZ6CyyYFUpH3P1wB3NSTS9a5zxvqx0bwrf3SttldPJi9dzcZ/AZP4VtSg20kclerc8V1K6/tPXL+86iad3H03cfpXQ6fH5dpGPUZrmNMgZ2RMZJ4rsAoVVUdAMCvqZLlSifNSlzSciJhWbrepJpGmXN9IpfyU3Kg6u3RVHuTgfjWm1YF9H/AGxrkFrwbXT2FxPxw02P3afh98/8BrOb0sty6aTd3stxPD2ltpOkQW8x3XR3TXL/AN+ZyWc/mT+AFZ2qBr3xZpVqrDbaxS3rj0OPLX/0NvyrpZAFDZICgZyTwBWJpNsZrq81aRSDdlUhBGCIUzt+mSWb8RQ42UYL+rEqV3KpLz+96fkXnGGNRsOalk5NQsDmuhHFMkSplqFKnUUM0Qy9sodSsp7O5TfFOhiceqkYNUfCN7LJZSabeMTf6Y/2aYt1kA+5J9GXB+ua1kFZer2E1new67Yxl5oU8q5iT708GcnA7spyw9eR3rmqJpqa6fkdFJqSdOXXb1/4J0KDim3dnDf2ktpcxrLBMpR1PcGktZ47qCOaF1eKRQyspyGB6EVYUZq3ZoaunpuZmj3NxaynSb+QyTxqTBO3W5iHc/7a5Ab8D3415IlnhaM9GGKr3unx30QVmaORGDxSp96Nh0I/UEdCCR3qayed48XCBZVOGK/db/aX2P6Vkrx0NZvmXMcZqNu8MrA5Dqe3avfPh74kXxL4dt53YG6hAhuB33jv+I5ryHxDYgEXAGQ3DexpngbxU/g/XhNJuNjPhLhR2HZgPUfyz61GOoe3pXjujbL8QqVXllsz6JKHrTDkdaks7mK6hSWJ1kjdQyspyGB6EVLJEGFfLo+pMDxRaS3/AIe1K1gZlmltpFjK9d2DjH414XFrDahpwn8xiwXDKTnawHIr6Ikjr52+LHg/UPCmsT6rpZZdPv2LHAyqOeqkfqPy7VjXoc9mt0RGWtj508bPNqOu3k7ZJ8wqPoOK5xbGV2A2mvQr/SXmneR1yzkseO9O0rwz504kdcRqc4x1rXoUaPw3+HOpatYy3VvGoVT8zuD1x04FdAlo9jK8Eq7ZI2KsPQivYfCcsem6Jax6dsFuYlOAvfHJ+uc5rnoPCJ8XeN547dCLKN1e7mUYVT1IB9TWFKuqkuRLUqV4K7OosppPDfwb3SEpPdoyoCOf3jHH/jvNY/w41Mab40s2Y4juVNux/wB4ZH/jwWn/ABY1qK41C10GzIFvp6fvFXoHI4H4DH5muUWWSEQ3ETFZYyrqw7MOhr6zB4b/AGZxf2j5jF4m2IjJdDH+IHh5rLxXqti+UKzuyehUnI/QivO9X8LXkhbyovN9l619J+PvD58deH7LxhpEZlu0iEd5CnLEL1IHqOfwx6Vm+C7W2XQoZolUySFjIwHOcnj8sV8riajoLVa3PpqdqiTR8m3nhy+jc7bd/piiy8P3zOMwFee9fUXxSh0B7KOK3hhF84VgETDLzyScdxn9K8yTTFz92tIyukwWpz+j6HLBCZJG5UZwK+jvgBpj2+l39+64ErpEh9doJP8A6EK8s0Tw1ea3fQ6ZYxGSaUjceyL3LHsK+lPD2iW/h3SLbTbYfJAmC399u7fia2pxbdzmxNRRVlua4fFDSVFuNIcngVtynJ7UXlzivIvi3r39oavDo9tJuhsuZcHgyHqPwH6k16B408UReE9GeYFWvZgUt4/Vv7x9h/gK8Nhje4lM0jNJLI25mbqxPevUy6hzS9q9lt6nDjanJDk6s2NCtMymUj5UHH1rcbio7G1+y2yocbjy31qV+lejKV2ealoUdQuWtYcxJvnkOyJP7zf4DqfYVBY2IsLYRb/MkZi8sp6ySH7zf4DsAB2qa3tZEka4uXEk7jHH3Y1/ur/U9T+AAlfrxSiru7CcrLlRUuoUuIzHKu5DgkE9cetMapn61C9bIwbIJKibrUz1C3WrRlMelTpUCVOlJlolWrCAjBqBR0qwnQVmy4oSztIrTesIKI7F9g+6pPXHpnr9atoKYtSLUbG123dkgqRaYtSAVDLEmhS4jaJxlWFcZqmnvbTvEwxjofX3rtwKranpq39v2Eq/dP8ASqhPlZEo9UHw2+Ip8OyppOqyMdPdv3cp58gnsf8AZ/lXuEN1FcRLJFIsiOMqynII9q+WryyeN2VwVZTgg9q3PCPxC1bwe4gA+16fnm3c42+6nt/L2rhxuW+0ftKW/Y9XBZlyrkqbH0Q+DVDULG21C2ktbuGOeCUbXjkGQwrG8PfEXw94jVVivVt7g9YLghGz7dj+BNdCy7hkdPWvFcZQdpqzPWupq8Hc8Z8TfAiGeZ5tDvFiVufIuMkD6MO31H41zCfBzxVBJ5awWpUfxiYbf8f0r6GaMntUM4jgjaWZ0jjXks7YA/GjliyPaVInk/h74R6pb8ajrUlvATkwWTtlvqTgfpXR+Itc0v4c6ELXTYYo7qQEQQryc95HPU/1NU/Ffxa0zTEe20YrqF308wf6pD65/i/Dj3rya6vbzWr6S9v5nmnkPzM38h6D2r1MHl3N781Zfmedica9r3YsZluJWnmdpJJGLO7dST3q/wCS32fODgHGais7ZpHVEBZicADvXcPoAGhm1wDN/rM/7f8A+rivblUULI8Vpzd0Ufhz4zHhXU2s7yQjTbphuJ6RP2b6dj/9au/174c2Wpu19ot7JpM843s1uA0UpxwxTpn3GK8Tu4DuKngiuq8FfFC78MBdP1JJLvTRwpBy8A/2fUe35V5WYZf7X95BXfVdz18vx3KvZzenQbqHwY8TS3LyG/srkscmR5GBP5ip9K+CeoNIralqNvDH3WAF2/M4A/WvWdK13SvENuJ9LvYblcfMqt8y/Veoqw6Fe1eNGnFOzR6c61RK6Zj+HvDGmeGbYwadb7C+PMlbl5D6k/06VrUUyWRII2lmkSKNeWeRgoH4mtlZaHG25O7H1neIvElh4U083l9INxB8qEH55T6Af1rl/E3xZ0zSo3t9HC6jd9PM/wCWKH6/xfh+deWajqV/4gvWvtRuHmmb16KPQDsPau3D4GdXWeiMauIhS0TvIsa3rd54p1R9RvnO5uEjB+WNeyitPQtP3t57r8q/d9zVLStMe8lCqMKOWPoK6yOFIIljQYVRgCvXk1CPJE8pydSXNIaajYZqVhTG6Cs0MgYVC4qdqheqRDK8nWoGqd+tV3rRGT3InqFutTOahbrVoymPSp16CoEqcdBSkWiZe1Tx9qgj96nSoZpAnWpFzUSGpVqDVEy1ItRCpAallko61IDwKrNPHEyKzgGTIXPerC1AX6FPU9Jj1CPKgLKOjevsa5G802S2kaOVCpH613ozTLm0hvI/LmQMO3qPoa0hVcdyZQvqjzKW15yM8elXLLxFr+lLtsdVvYEHG1ZTt/LpXRX/AIWkBLWrB1/ung1iT6XNbnEsTr/vDFbXhNa6ijUnB9h7/EPxgyhDrl0APTaD+eM1i3+parqzZ1DULq69pZGbH4Grz2ef4aRbE5AA5pwpU46xil8i5YmbWrM6K2GRwa0be2OQAuTWnYeHbu6I2wsq/wB5uBXV6T4et9PIkfEsvZiOF+gpTqqJlrPYg8O6D9kAurhMS/wqf4R6n3rfoHHvR1rjnJyd2bRjZWOU8UaJtdr2BPkb/WAfwn1rkLm268V6ywDAggEHgg965jWfCxfdNZD3MRP8q3o1re7IynC2qOAjM9nMJraaWCVTw8bFSPxFbdt8Q/F1mAqazNIo6CUK/wCpFQ3GnyRMVljZGHZhiq5tMdjW8oU5/EkzSNeSVkzUk+JXi+cEHVNmf+ecSD+lZF7qGp6u27UL66ujnP7yQsB9BUq2hHarNvp8kzBY42dvQDNKNKnHVJImWIb0uUYbb2rZ0zSJLxwEXCj7zHoK09P8MEYe6O0f3AefxrfSGO3QJEoVR0AqJ1exEYyk9SG2tIrKERRDAHU9yaVjS3E6QLukdUHqazf7RN5OIbcEJ/FIeuPasUm9TRtLQumo2NPbio3NCB7EbGoXqVqgetEjJ7EMnWoHqZ6harRkyB6iNTPULdatGUx6VOvaoEqZaGaImWp0qBDU6dKhlImWpVNQrUo6VDNkTLzUoqFDxUims2WjI16C9RBPGwuIUOWiIAdc91PQ9Oh/PtVfTfEUnlhlYTxdOeCMcY9iPQ10TKsiMjDhhg159q6T6Lfy3yDfar/x9QovzYBx5i84JA6jjgdeBVRdlrsTKHNKy3O5g120kIDsY29GHH51owzxzDMciOP9lga4qSwmQJKuZEkG5MAgsPUA8ke/Sq/nGM9SrA/Q0RjTqK8GD9rTdpxsehU7AYYIyPQjNcLDr93bkBZ2IHZjn+dadt4vZT+/jVx6qcGpdGSGqqe50psrV/vW0R/4AKdHawR/6uGNcdwoFZtv4k0+YcymM+jCrkep2bj5buH/AL7FQ1ItSiW84xxTs1U/tC0/5+of++xSNqlip+a8tx/20FTysdy6DRk1QOt6anW+t/8AvsU1vEOlKCft8H/fVPlfYVzQJxSVlP4o0hRn7ah/3QT/AEqvJ4y0tB8ryP8ARf8AGhU5PZDujYmtobgYliSQf7QzVF9B04n/AI9wPoxrIm8d2qjEUDn/AHmxVCbxvcuD5axIPUDP860jSmQ3HsdKuiaehyLZTj1JNPeezslwWhhA7ZA/SuGn8R3d0SGuXIPYHA/Ss651e3thuurqKIesjgZ/OtPZP7TJi2/gR3dx4ksoshN8h9hgfrWbceIriXiJVjHr1NcgmvwTf6hLi59DFC20/wDAjgfrVu1fUbx1S204ljwBJKM/koahezWoShVbNCe7Zg0txMTjqWOcelbehRTrbGWaEQrJhkBOXI9/T6c9ecdKzdG8LX2pebqWoXEUFrbzGKCKNMmWReGYknHBBA47H2NdM1ZKvGpfk2RcsM6VufdjG5qN6kJqJutUiWRsahepWNQuc1oQ9iF6gap36VA1WjEgfqKjbrUj9ajbrVmUx6VMtQpUq0maIlU1YU1WSrCGs2UiZTipVaoAalXpSZqTLUqmoVNSLzUMtEw61zmvxBLtmIyHQEg9D2NdCDzWP4hXLRP6qR/n86dP4hVNi58L76K4sr3wveokwsCrwJIuQ1s+do567WDL+Arpr/wDoupZbypraQ9HgkI2+wU5X9K8u0nUv7C8Z6LqO4rFNKbC49CkvCk/Rwn5mvd7dQ1fO42Do13y6H0+DqRr0E5K55tqPwneFC9n4haNCyrm8tRKckgAZQp1JA6Vi3nww8ZW2TbppV6BzxcPEx/AoR+te2S6el7azW0oPlzRtG2OuCMVB4UvH1nQ4LidVF1GXt7oKMATxsY5Me25Tj2xShmGIjtIuWCoS3ieAXXhzxrZH994Vv3A7200Un6bgayprvWbbIufDuvw47tZsc/lmvqk2YPaqOriPTNLvL6RQUtoHmPbhVJ/pW8c2rLcweWUH0PlV/ExQhZLTU0J6brOX/4mqs3jK0jYq7Tq3obeUf8AstfW8OkIII0mAlkVAGcj7xxyaVtFtmOWgjP1WtFnFTqhf2XSufIbeLbZhlWuCPa2l/8AiadFrrz/APHva6jOe4is5WI/8dr68GjwKOIUA+lQxQxvqM9kIQPJhil3A/32cYx/wD9aP7Yq9Eiv7NpHytG2tTnEXh7xA/GR/wAS6UZ/MVai0rxdc7TB4Q1xg3eWNIx/481fVX9mL/dpf7OH92oeb1n2H/Z1HsfLyeDviFcg+T4XWD3uLxAfyH+NWovhd8QbniU2dsP+mYUkfizEfpX0Pqai1n0+2U7Hvbnylb/dRpCPxEZH41fGnAdqzeZ1nv8A191ivqFLoj57tvglr05/07UTL6h7plH/AHzGoH51u6Z8EobRg5ntoW7mG3+Y/wDAjzXtBsQO1Y9jnUtVvpUYi3sm+yoATh3wrOSO+Mqo9CG9ah5hW6WXyL+p0+t/vOTsvhro9mAZjPdHv5j4H6Yqx4hMPhfw7dS6XbxQ3Mmy3ttqDmeRhHHn1G5lz7A12EsIArjPFzi48ReGNOOdn2mW+lHYpDEwGfo8kZ/CuedepUfvNs1hRp0/hikVruGHTYLXSLYkw2cKpzyScdT6nv8AjVJjmmJc/bJJrs/8tpGI+mcD9AKD0r6LD0/ZwUT5jEVva1HIRj0qJjinOaiY10JHO2Nc1E1PY5qJzVkS2IpOtQtUjniomPFUjIifk1E5Oakao2PNWjOZIlSJ0qJakXpSYyValBzUK1KpqWWTp6VIpqFeAKkBqTSJOOalUgVADxTwalotMnU4rL8QjMMZ9yK0Qaz9c5tU/wB6iHxBU+E4jxNG8mj3XlEiZIzLER1Dr8yn8wK+gvDOorrOkWGpJ9y7t451x6MoP9a8KvACNp6NxXp3wUuDcfDrQwST5MTW/P8A0zdo/wD2WvJzmFpRl6nuZPO8JRPTLePgGua8JH7D468XaKT8jvb6rCpPQTR7H/8AH4WP/Aq6OI3QI8iKF1/25Cp/RTXKTWmsR/Fu0kjubKKW80KRJGa2Z0xFOpAHzqSf3p5/SvEPZO98o1y/xUDQ/DTxTKrFSul3JyO37tq1pdN8SSEhdd0+NSONmnNuB9cmUj9K5jx/4P17UvBet20viu9l82xuFaCK1gRJcxt8v3CwB6cHPvQB3EaLLGsifMrgMD6g07yPauI8P+DrvWfDmm3svjnxW63VnDKuya3i2hkBwNkI9e+T71cf4X2cpQzeJvF0jKMZ/tiZc/XBFAHWfZ65fSbj7R8SvEdmD8ttpemkj0ZpLwn9AtQy/CbQZHLvqXijcepGvXg/lJXIeH/hpo9x8QvF1nJqHiIRW0Vh5TLrV0HIaOQncwkywznGTxk460Aev/Z6Ps4rkD8MNNRlaDxB4rg2LtULrU7Ae/zMc/jTk8B6jbYNn498UJgAbZ2t51PXrvhLd/X0oATXWLfEnwrZbwFFrf3JXBydoiQf+jK6/wAgV5VrOkeL9O+I/hi4TXdP1KV7O/gja7sjFtB8lyCY35J2DBC8c9a7SHxD4gsfl1Xwy8i95tKuluFHuVcRv+ChvxoA3mhrifhjML7wdFfENuu7y8nbd1ybmXr+ldRY+JNM1SRobe5AuFG5reZWimUepjcBgOeuK5L4TL5HgO1tWyHt7q8hfIx8y3MoNAHQ3WMHFeV+Mr7yfHKMesGg3Hl/WWeFSR6HCV6ldsBmvG/iNdhPHEVtzul0tW6dlmbP6kV0YWHPWjF9znxc+SjKXkWrA7bGIf7OalZuKr6exayiye2KlY19O92fJJ+6hrHNRMaexqI1aQm7CE8VE5p7HNQucE00ZsjaozTz0pjGrSIexE9Rt1qQ9aifrVozlsSZp61HTweBUspko4p4NRinqRSaLJlbAxUgPFQKalU8VI0SqalU1ADing4qWaJk4NU9Z5s1/wB/+hqyrVV1Y5tP+BCiO4T2OZuhwK9B+BzkeB4Yh92G9vEX6faJD/WuAnGcV6L8GkaPwDpzsOZZbmbpjIe4kYfoa8zOX7sV5v8AQ9rJlrP5HqNo+FFZjxef8QLS42t/o2lTKW7AySx4H/kNvyqzBNgdcVKDCly92P8AWvGsZP8AsqSQPzY14B7psmcCopZVkRkYAgjBrMe+HrULX/XmgCHwOjaZ4U0/TWP/ACD0axXtlYWMSn8QgP41tG7HrXH6r460DRjt1HW9OtG6BZbhVY/QZzWDP8YPDoGbV9Sv/e10+Zl/762hf1ppX2Bu256W16PesCxgNr4v1jUPm8u7tLNcnP3kaYHn6FeP8RXn8/xoQn/RvDGuyj1kMEQ9uDJn9Kz5vjTqfWLwfcsvIPmX0an9Aa1jh6stov7jJ16a3kvvPavtw9aT+0BnrXin/C5dWxk+EiP+4gv/AMRSJ8aNRDHzvCM4UDgx30bE/gQKv6nW/kZH1qj/ADL7z1PXka51HQ9QjUs2n3pdgOpSSKSI/gC6sf8AdrdW+X1FeNQfGq0OPtPh3XIfdVikH6Pn9K0Lb4yeFZGCz3l1ZMf+fq0ljA/4EV2/rWcqNSO8X9xpGrCXwtM9PvobLU0WO7t4pgpyu9QSp9Qex9xXN+CLYaUmu6YMhINVmkTcSSVlCzdTyeZCPwqPSvFulaym/TtTs7xf+mMyt/I1dt/Liubi4UnfcbN/1UYz+WPyrNprc0uXLp81418Uk8nxxodwelxp9zDn3R4mGfwLV67LKG715V8aYmil8N6gCQsN60Dn2kQqP/HttdGDdq8X5nPi481GS8iPSJd1rtz90mrjNWLpE+yQp2YfrWozehr6mUdT46m9BWPNRtQSaY7UxyYjNiomOaUmmt3FNIzGE0x6cTUbc1ZLfQYeKY45pxqN+tNEy2JO1OXmmdqetA7kgNOGcUwU4MMCkOJIuakQnNRKeacG7VLRRMDmpAfWq4OKer+ppFXJ91VdUb/RlH+1/Spg1UdTkzsX2JoitRyloYOrXK2VhcXLfdhiZz+ANev+BdPbR/CGi2DjEkNlCsn+/sG79c145q0H2+ex0vIxeXCiTPQRKQzk+3AH/Aq9S1Lx7p1ixtNOQ39xGNpWM4jT/ef+gBPtXkZpCdWcYwVz3crnClTcpu1ztFnKjg1z+pfEDSrMMtq8mpSgldtphkDdw0hIjU+xYH2rhb+51jxC5OoXBWA9LZPli/EdW/4Fn6CnQ6XEuPMJkKgAZOAB7VhSyqT1qOxpVzeC0pq/qX73x5rt+5S3ks9NU/wwxtdTfizbEU/QOKx57C81f/kIzajfq3UXt2wT/v3FsXHsQfxrWjRIxhFVR7CpA2K7oYCjD7N/U4J5jXn1t6GXZeHYbLP2eO1sweotLdIz+YAJ/Grn9k27HMpkmPq7k1Z3UB66YwUdlY5ZTcvidxiadZp0tovyzUn2a3HSCL/vkUBhQWFN3ZGgxrK1Yc28R/4CKgfSLJhzAB/umrJekL5FNXE4xKD6DZsOA6+2arv4diOdkpH1Fa26k3U1JhaJzFz4Lt5HEpggMo6SJ8jj6MMEfnV2xv8AxR4fx9j1Ga4iX/lhe5mU+wf7w/M/StgtUZYVM6UKnxo0hXq0/gkbug/EG11B1ttShOm3LcDe26GQ/wCy/b6Ngntmq/xa0l9a8G3UUJxNGVljYfwuD8p/76xWNNFFL99Fb8K1bPUPtWnz6TdMXSWMpE7nO1uwJ9M4rzamXqnNVKe3Y9SlmTnF06m/RnB6Nei7s7e9jyBLGsgH90kcj6g8V0iSCRFcdxmuVtbaTSdRutPdSsUjNc27diCfnX8GOfo1btlMdpjPbkV68XzRuzxKqUJ2WzLbN270wmgn86YT600jMUnvUbHmlJOfamk5qgbENMNK1MJpogaajfrUhpj4zVIUthw7UvSgdKO1IY9Se9OBpg5pc0gJA1OB5qPNOBzQPbckpwNRgmgHmk0UTB6zrqUSOzlgoXqT0AFW5JNqMe/QVQbTWvJFFxgWowzIOsp9G/2fbv8ATgq/LqJLmdnsVNL019Sml1GXeiTp5cPVWWLPX2LHn6Y9K6C0sreyQJDGqgdMUK2BjoKXfUpWNZT5iwHx0p4bnmqyt604PRYakWN+KUNUG7NKGwKQcyJw1Lu96gEhpfMpWC6J91IWqHePWguPWlYZLuoLVD5lHmE9TTsK6Jd49aTfUJajfTsHMSFzTCw70zePWmbzTE5Eu7mml8d+lRmSmmQ0WJ5iDUbMXkS7GCTRN5kTnna3v7EEg+xqCF/MUTKjRup2yRHko3cZ7j39CKuFzTCec9aajZ3QOV42HFgRkd6TINN4pCcVRHMOz27UzPNJnNGaYCGmN1pxNM70xBTGxmn0x+DTRMth46Ue1FFIYoOKAc0lFADyaVTTNx6Uo6daAJN2KXPvUf40A0g1JCAcZ5p2761FuFG6lcZKGNP3VAHpd9A7kwcCnB+9Vw3enb+KVgJ/MIpfMqtvpd9Fh8xY8zml8z3qvuo3UWFzFjzPek8yoN1AelyjTJ/MpBIag3c0b6dguT+ZQXqDfRvNFguSbqMioi+aTdQkK6Jc/Wm5phek3UwuOLUm73phakzTJ1JC1NJpucd6TcaAHZNJmk3UlMYpPpSHpRRQIKY55px4FMY80ImWw0XUP/PeP86Bdw/894vzr5S3n1P50u5vU/nXhf2zL+T8T6L+wl/P+H/BPq37TAf+W8f50faoP+e8f518pbj60bj60f2y/wCT8Q/sNfz/AIf8E+rDdQf894/zpftMP/PeP/voV8o7z6n86XcfWj+2ZfyfiCyJfz/h/wAE+rftMH/PeP8A76FH2mD/AJ7x/wDfQr5S3H1o3H1o/tl/yfiP+w1/P+H/AAT6t+0wf894/wDvoUouYevnx/8AfQr5R3H1pN5o/tl/yfiL+wo/z/h/wT6w+1Qf89o/++hSfaYf+e8f/fQr5Q3mjeaP7Zf8n4h/YS/n/D/gn1h9qh/57x/99Ufa4R/y3j/76r5Q3n1o3H1pf2y/5PxD+wl/P+H/AAT6v+1w/wDPeP8AOl+1w/8APeP86+TwT2NG4+po/th/yfiH9hL+f8P+CfWH2yH/AJ7x/nR9sh/57x/nXyfuPqaNx9TT/th/yfiH9hL+f8P+CfWH2yD/AJ7x/wDfVJ9rh/57x/8AfQr5Q3GjcfWj+2X/ACfiCyNfz/h/wT6v+1w/894/++hR9rh/57x/99V8obj6mjefU0f2zL+T8R/2Gv5/w/4J9X/a4f8AnvH+dH2uH/nvH/30K+UNx9aNx9aP7Yl/J+If2Gv5/wAP+CfV32uA/wDLeP8AOj7TB/z3j/76FfKOT60bz60v7Zl/J+Iv7CX8/wCH/BPq43UB/wCW8f8A30KDcwf894/++hXyjuPqaNx9TT/tmX8n4h/YS/n/AA/4J9W/aYP+e8f/AH0KPtMH/PeP/voV8pbjSbzS/tl/yfiP+w1/P+H/AAT6u+0wf894/wDvoUv2iD/nvH/30K+Udxo3H1p/2y/5PxF/Ya/n/D/gn1d9og/57x/99Ck8+H/nvH/30K+Ud5pdx9aP7Zl/J+I/7DX8/wCH/BPq77RB/wA94/8AvoU03UIP+vj/ADr5T3MO9IXPqfzo/tmX8n4i/sJfz/h/wT6t+1Qn/ltF/wB9UxrmDP8Ar4v++hXyrvPqaN59aP7Zf8n4ieRL+f8AD/gja9I+Fvw90rxraXlxqFzdK1tKqeXCQOCM5JIPofyrzerlhq9/pbM1he3NozjDGCVkLfXFeTRnCM05q6PbrQnODjCVn3PoGH4LeEIB89tdzn/ppOf6Yqb/AIU74NOSNMk+vnyf41zPwI1C+1KXWHvLy4udoiC+dIXx971Ncl8aNRnn8b3dq8rmK3SJVTcdoygbp/wKvYlUoxoKr7Nanixp154h0XUeiMLxToUFv4xvNH0ZWmj+0CGBVbdknHy578nFesaH8CtFg09BrE1zcXhGX8l9qKfQcc/WuI+COlR6h4y+1SDIsoHmUH+8cKP/AELP4Vc+Oev3Fx4jj0hZGFvZxKxQHgyMM5I+hFctKNOFN15xvd6I7a0qk6qw9OVrK7Zp+LvgbHb2cl34euZ5HjG42s+CzjvtYY59iPxry/QdNj1TXbLTbif7NHcTrE8hH3MnHSvV/gb4tu75rrQL2Z5hDH59sznJQAgMufTkEfjXFfFbSV0Px3eeQPLSfbdIF4wW64/4EDU4inTcI16asuqHhqtVVJYeo7vdM6L4o/DHTfDGhW+paQJ8ROIrjzH3bs5w3tyMfiK534cfD1/G9xctNPJbWVuuGlRQSXPRRn8z/wDXr2k4+IHw7G0qZNQs+/QTD/BxTdJs7P4ZeBs3BU/ZYjNORx5kp7D6nCj8K65YKEqqqfYtc4o46pGk6d7zvY8A8aeF5PB+vzaTJcx3JRVcSIMZDDIyOxrCq9rWq3Ot6pcajdvvnuHLsfT2HsBxVGvFm4uT5dj3IJqK5tza8HaGviTxJY6W7mOO4lAdh1CgEnHvgGvd7r4aeAtMiVryxtoEPAea5Zc/iWFeNfCtivj3SMHGZWH/AI4a9G+PWnXmo22im0tJ7jY8wbyoy+3ITGcfQ16WEUY0JVHG7R5mMc5YiFJScU10H674Y+GUejX7WlxpkdwkEhiMd9uYOFO3A3nPOOK8c0HRbnxFrFtpdmMzXD7Rnoo6kn2AyarXlhdafII7u3mt3POyVChx9DXe/AqOJ/Grs+N6WkhTPrkA/oTWDkq9WMeXl9DojB4elKXM5ep6Bp/wX8KafZImoCW7m4DzSTGME+wBGB+deefFnwbofhG4s00qeUS3AZntnfdsUYw2eozz19Kt/Ha5vz4mt7eYuLNbdWgXPykkncfrkY+gFeaM5bqST71pi6tJXpRha3UywVKrJRrTqXv0PW/h58KdC8T+GbbVr26vTLKzq8cTqqoQxAHQ9gD+NdjD8F/B0Q2tZ3Mp9XuG/pivALLXtU06FoLLUby2jY5KQzMgJ9cA1718Fbq5vPBry3VxLcSNeSfNKxYgbV4yfpW+BlRqNU3DXuYY+NeknUVTTsTS/B/wWkTs+nyRqAcubhwF98k4rz/4XfD/AErxPcandajvmtLWXyYokcqHJydxI7Y/nXG+NtRuNQ8VarJPK74upVXcxO0BiAB7cV6x8AD/AMU/qQA5+1j/ANAFKnKlWrqKgklf5jqxq0MNKTm23b5GufhT4EuJTFHbL5g4KpdtuB9Mbq8/+JPwpj8MWf8Aa2kzTS2KsFlilwWiz0OR1GeK5TWdMvtU8ZanbWNtNcTtfTBUjUk/fNe3eO2OkfDC6t76XzZhaRWzMxyXk+UZz3OQTVWp1oT9y3L1E3Vw9Smufm5nscX8Ivh3o/iHSLjVdXhNyDMYYotxUKAASTgjOc/pXW3Pgn4Z2cjR3K6XA6nBWS+KkH6F6h+A7bvBcwJztv5B9PkQ/wBa8h8S6Bqx17VZf7MvTGLmVy4gbbjeec46UuaFKjCSgm2HLOtiJxdRxSNj4q6V4X026sP+EamtXWRH85Le480KQRgk5OD1/KrPwx+GKeLo5NT1KWSLT438tUj4aZh157AevvXnZNfRngYTW3wngk0wbroWc7xY6mXL4/HNYYWMK9ZykrJK9kdGLnOhRUYy1btcZdfB/wAFSRSRrBLbtGuWdLk7kHqd2R+lfPmoxQW+oXMNtKZoI5XWOQjG9QSAfxFJNczSSySSSO0jkl2ZjlieuagrDEVoVLcsbG+GoTpX558xoaBpja1rdjpqEqbqdItw/hBIBP4DmvWfiH8LtD0PwdPfaVbyrc2rIzyPIWLoTg5HTuDwO1cl8GNLN/43t5yMpZxPO3HfG0fqwr3jxBaR6zoeqaepDF7eSIj0YrkD9RXZgsNGdGUpLXocOOxUqeIhGL06/M+TCOa7/wCGfw0PjHffX8skGnRNsGz70rdwPQD1rgiMOQe1fRc8x8C/CcSWmEmhs12sByJZCPm/Nq5sHRjOTlPZanXjq0oRUKb96TsVL34GeGZoGEEt/bSdn8wOPxBHP514/wCM/Bd/4N1IWt2yywyAtBOg+WRf6EdxVXQfFOpaBq8ep2lzKJQ4aQFiRMM8hvXPvXt3xVs4PEnw7OqRDmFY7yI9wrYBH5N+grZxpYinKUI2aOdTrYarGNSXNGWnzPnmkpTxSV5h6oUUUUAe0fs9f6rWf96H+TVw/wAWHL+P9XJ/vxj8o1Fdx+z1/qdZ/wB6H+TVwvxU/wCR+1f/AK6J/wCgLXp1f90h6/5nmUV/ttR+X+R0/wCz/wD8h7VP+vQf+hrXOfFxi3xA1TPYxj/yGtdH8AP+Q9qn/XoP/QxXPfF8EfEHU/8Atl/6LWpqf7pH1/zHD/fpf4UW/gk+zx3CvPz28q/pn+lW/jv/AMjhAfWzT/0JqrfBCMv46ibGdtvKfpwB/WrPx4P/ABWEA9LNP/Qnpr/c36jf++r/AAnXfATVWutAvdOfn7JOHU+iuOn5g/nWT8efEjGa18PwkhAouZ8fxHkKPw5P4in/ALPX/Mc/7Yf+z1yfxnYt4+vAScCKID/vgVrUqNYKPnoc9Omnj5NrbU4c80lFFeQeydT8MGC+PdGJ/wCfjH5g19A+LfGml+C7WC41JbiTz3KRpAoZjgZJ5IGOnfvXz58NP+R70X/r5WvQv2hji30L/fn/AJJXq4SrKnh5zjumeRjKUauJpwls0zjfih45svG19Zy2NrPBFbRsmZsBnyc9ATjGPWuf8K6/P4Y1611WDkwN8y5++h4ZfxBNZJOaAcV58qspT529T040oxh7NbH0p4l0DS/ih4VguLOZPMIMtpP/AHGxyjeg7Edse1fO+raXd6NfTWN9C0NxCxV1b/PIrq/hj4/l8I6n9muWZ9LuWAmTr5Z6bx9O/qPwr0P40+GLfWPDieILUI09oFJkX/lrCxH54yCPbNehVjHFU/ax+Jbnm0XLCVFQlrB7eXkeCjrX0R8ER/xQsX/X1L/Svnjbg19EfBH/AJEWL/r6l/pWeWfxvkzXNf8Ad/mjwPWnMmsXznq1xIT/AN9GvZ/gD/yL+pf9fX/si14tq3/IVvP+u7/+hGvafgB/yANS/wCvr/2RaWXv/aL+oZkv9mt6HpFjLp9xJcGxe1crIyTGEqSH7hsd/rXg3xe8VazqOtSaPfWxsrW0fMcIOfM9JCe+R09M1W8M+Lrjw58Qp7gyMLa6vnjuUz8rKzkZ+ozn8K7f496NHNpNhrCIBLDIbd27lWBI/Ig/nXVWrOvQly6W3OWhQWHxEVLXmWjLvwEYHwfdr3F+5/8AIcdT638avD+k3d1YrZ39xPbu0eVRBGWHB5LZ/SqvwD/5FS9/6/m/9FpXi/iU/wDFRap/19zf+hmlLETo4enydRxwtOviqnP0sZ00nmyu4ULuYnA7V698EPG8VsW8N30mwOxe0ZjxuPVPx6j3z6149T45GicOjFWU5BBwQa8yhWdKamj1K9CNaDhI9V+Lfw2bT5pdf0qPNpI265hUf6lj1Yf7JP5V5QRyRX0N8LvHaeL9LbS9S2PqNvHh93S4j6bsevODXkfxH8MJ4W8U3NlCMW0gE8HsjdvwII/CurF0YuKr09mcuCrTUnh6vxL8Ueh/ADSfL0/UtUZf9dIsCH2UZb+Y/Kuv8A3dzfQ61NdRSxM+qzFVlUg7MLt69sUngiG18J/D2wnvCIYobf7VM2Om75j9TyBVzw3470HxXcSwaXdPLNCu8o8ZQ7c4yM16uHjGEYRbs7bep5GJnKpKpNRurrXtY+a/EVmbDxDqVpjHk3UiD6BjivcfiqxX4X8dGFsD+hrzL4wad/Z/ju9YLtW5Ec4/FcH9Qa9P+KQP/CrWx2W2z+a1wUY8qrRPSrz55UJd3+h89DrX0JM/m/BMsef+JUo59gP8K+e6+hbhPK+Cm0jB/slc/kKywG0/QvMP+Xf+I+eTSUppK849IKKKKAPaP2ev9TrP+9D/ACauF+Kh/wCK+1f/AK6J/wCgLXUfBPxJpHh+PVRql/DaeaYmTzD97G7OPzFcV4+1W21rxdqd/ZyeZbyyjY+CNwCgZ5+lejVmvqsI31v/AJnn0YSWLnJrS3+R1PwK1GO18WT2rnDXdqyJ7spDfyBo+OOjTWvisaltJgvYUw46blAUj8gD+NcFpGq3Gi6nbajavtmt5BIh9SOx9j0r32x+JXgvxNpMf9rTWsLcF7a8j3BW9RkYP1FVh3CrRdGTs73RniVOjXVeEeZNWZx3wD0e4bV77VmjIt44PIVz0Z2YHj1wF/Wuf+MupJf+OrtEOVtY0gyPUDJ/UmvR9e+LnhjQNKMGgNFdXKgiGKCEpFGfUnAH4DrXgt5dS3t1LdTuZJZnLux6sxOSaWJlCnRjQg79WVhYzqVpV5xtpZI9e/Z5OTro9oP/AGpXI/GN93j+/wCnypEOP9wVpfBnxZpXhi91JdWuhaxXMabXKsw3KTxwD2Y1zXxD1i11/wAYajqFk/mW0rKI3wRuAUDPP0qalSLwkY31v/mVTpyWLlO2lv8AI5yiiivPPQOl+HDhPHOik/8AP0g/PivRP2hfmttCx/fn/kleU+GtSj0fX9O1GUMY7W5jmYL1KqwJx+FfRE3jnwJqsET3epaZOgGVW5jyVP0YZFephFGdCdNySbPKxjlCvCqotpX2PmXb9Kt2WkahqW77FZXN1s+95MTPj64Fe+X/AIn+GJt5UdtHcbT8sdnktx2wted/C34iW3g+6ubK/Rzp9y4fei5MTjjOO4x/KsJYaEJqMpqz7HRDFTnCUowd10fU4GOGQy+WFO/OAuOc+lfQ+swzWPwdkgvAUmj0yNHDdQ2AMVak8a/D+IjUxfaUZvvCRYMzD8Au7NeafEz4qxeKLT+ydIjljsSwaaWQYaYjoAOy9/XpXVCNPCxk+a7asjlnKpipwXI0k7u55tmvof4I/wDIixf9fUv9K+d85Ne2fCjxp4f0HwYLfUtThtpkuJHMbZLEHGCABzXPl0lGrdvozozKEp0LRV3dHjurf8hW8/67v/6Ea9q/Z/B/sDUf+vsf+gLXiF7KJ7yeYdJJGf8AM5ru/hv8TbXwRp17aXNjNcmaQSo0bAYOMYOfoKjCVI063NLbUvG0pVaPJHfQ4rVnL6teOeC07nj/AHjXv3jw/wBufCiW7+8zWsF1nHU/KSf1NfPVzP8AaLmSYjBkYsR9TXs9v460GT4TnTJ9RiF//Z72wtyCWLBSq9vpWuEqRtUi3ujLG0pN05RWzRe+ATf8UvfJ3F6T/wCOJ/hXjPiZSPEWqZ/5+5v/AEM16H8GPGuj6Ba32n6rdi0M0qyxSODsPGCMjoeB1rvJvFHw3d2kmuNCkdjlmNurFie5+XmtvZxrUIR5krdzD2k6GJnJwbTtsfNuw1budG1GyhSe5sbmCF+EkkiZVb6EjBr0D4ra34RvoLD/AIRv7IbqOVmle2tzGAuBjJwAea7Xwv8AFbw54g0uK2154Le6VQsqXKZikPTcDgj8DXLDC03Nwc/R9DrniqigqipvzXVHAfBKzupfG0VxHGxhhhk81uwBXAB/EitP41wG/wDHWk2i8vJaxRkD1aV8fzrtdR+KPgvw1atHp0kVw/JEFjFtUn3bAX+dePSeMzqnji38R6sjMiXKSmKPnYikYVc+mK6Kvs6VJUea7buznpKpVruu42SVl5nsfxfu10vwDPbRtt89orZcdgDk/opryn4Q6ibDx3YLk7bhXgb8VJH6gVofFH4lWHjOys7LTIbqOKGQyyGdQNzYwuME9ifzrjfC+pLo/iLTtQc4S3uEkY/7IPP6VGJxEZYlSi9FYrC4eUcLKE1q7npP7QOnhL7SNQAyZY5IWP8AukMP/QjXZa3A3jD4UkWQ8ySeyjlVR1LJglfrlSK4r4z+MdA8Q6fY2elXq3c8MxkZkUhVUrjGSOT06VB8J/ibaeH7c6LrUjR2m8vBPgsIieqkDnHeuj2tNYicW9JIw9jVeHhJL3ovY81trG4vLuO0giaSeRwioo5JJ6V9AfEWRfD3wuksnIEhggs1924z+itVg+Nfh7p08l/He6Yly+SZIYCZG/FVzXkvxL+IX/CZ3kcFqjxabbEmNX+9Ix6sfT2H+NZWhhqclzXb0LvUxVWDcHGMddTiDSUtJXlHrhRRRQA7dSE5NJRQAU4NxTaKAHE5702iigBQcd6DSUUAFFFFACg0u6m0UAO3e9IDikooAdu9TSGkooAUUu7jFNooAU0lFFACjg0u6m0UALml3fWm0UALml3U2igBc0lFFABSg4pKKAFLE96AcUlFADi2TSE5pKKACiiigD//2Q==\n";
        st.setImg(img);
        assertEquals(img, st.getImg());
    }

    @Test
    public void setImg() {
        assertFalse(this.studentTest.setImg(null));

        assertTrue(this.studentTest.setImg("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\n"));
    }
}