import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private final Person p1 = new Person("Якушев Нисон Тимофеевич 13.06.2000");
    private final Person p2 = new Person("Тарасова Ксения Андреевна 15.03.2000");
    private final Person p3 = new Person("Тарасова Андреевна 15.03.2000");
    private final Person p4 = new Person("Тарасова Ксения Андреевна 15.03.1000");
    private final Person p5 = new Person("Тарасова Ксения Андреевна 15.03.3000");
    private final Person p6 = new Person("Тарасова Ксения Андреевна 33.03.2000");
    private final Person p7 = new Person("Тарасова Ксения Андреевна 23.33.2000");
    private final Person p8 = new Person("Тарасова Ксения Андреевна 0.33.2000");
    private final Person p9 = new Person("Тарасова Ксения Андреевна 12.00.2000");
    private final Person p10 = new Person("Тарасова Ксения Андреевна 12.15.000");
    private final Person p11 = new Person("Тарасова Ксения   15.03.2000");

    @org.junit.jupiter.api.Test
    void Person() {
        assertNotNull(p1);
        assertNotNull(p2);
        assertNotNull(p3);
        assertNotNull(p4);
        assertNotNull(p5);
        assertNotNull(p6);
        assertNotNull(p7);
        assertNotNull(p8);
        assertNotNull(p9);
        assertNotNull(p10);
        assertNotNull(p11);
    }

    @org.junit.jupiter.api.Test
    void getPerson() {
        assertEquals(p1.getPerson(), "ФИО:Якушев.Н.Т  Пол:Муж  Возраст:19");
        assertEquals(p2.getPerson(), "ФИО:Тарасова.К.А  Пол:Жен  Возраст:20");
        assertEquals(p3.getPerson(), "ФИО:  Пол:  Возраст:-1");
        assertEquals(p4.getPerson(), "ФИО:Тарасова.К.А  Пол:Жен  Возраст:-1");
        assertEquals(p5.getPerson(), "ФИО:Тарасова.К.А  Пол:Жен  Возраст:-1");
        assertEquals(p6.getPerson(), "ФИО:Тарасова.К.А  Пол:Жен  Возраст:-1");
        assertEquals(p7.getPerson(), "ФИО:Тарасова.К.А  Пол:Жен  Возраст:-1");
        assertEquals(p8.getPerson(), "ФИО:Тарасова.К.А  Пол:Жен  Возраст:-1");
        assertEquals(p9.getPerson(), "ФИО:Тарасова.К.А  Пол:Жен  Возраст:-1");
        assertEquals(p10.getPerson(), "ФИО:Тарасова.К.А  Пол:Жен  Возраст:-1");
        assertEquals(p11.getPerson(), "ФИО:  Пол:  Возраст:-1");
    }

    @org.junit.jupiter.api.Test
    void sex() {
        assertEquals(p1.sex(), "Муж");
        assertEquals(p2.sex(), "Жен");
    }

    @org.junit.jupiter.api.Test
    void age() {
        assertEquals(p1.age(), 19);
        assertEquals(p2.age(), 20);
        assertEquals(p4.age(), -1);
        assertEquals(p5.age(), -1);
        assertEquals(p6.age(), -1);
        assertEquals(p7.age(), -1);
        assertEquals(p8.age(), -1);
        assertEquals(p9.age(), -1);
        assertEquals(p10.age(), -1);
    }

    @org.junit.jupiter.api.Test
    void fio() {
        assertEquals(p1.fio(), "Якушев.Н.Т");
        assertEquals(p2.fio(), "Тарасова.К.А");
        assertEquals(p3.fio(), "");
        assertEquals(p11.fio(), "");
    }
}