package com.bulavin.webapp.model;

import com.bulavin.webapp.util.DateUtil;

import java.time.Month;

public class ResumeTestData {

    public Resume getMockResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        String phone = "Phone: +7(921) 855-0482";
        String skype = "skype: grigory.kislin";
        String email = "email: gkislin@yandex.ru";
        String linkedIn = "linkedIn";
        String gitHub = "GitHub";
        String stackOverflow = "StackOverflow";

        fillContacts(resume, phone, skype, email, linkedIn, gitHub, stackOverflow);

        Section objective = new TextSection("Objective", "Ведущий стажировок и корпоративного обучения" +
                " по Java Web и Enterprise технологиям");
        Section personal = new TextSection("Personal", "Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры.");
        Section achievements = new ListSection("Achievements", "Организация команды и успешная " +
                        "реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы," +
                        " система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2," +
                        " многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный" +
                        " maven. Многопоточность XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие" +
                        " (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.");
        Section qualifications = new ListSection("Qualifications", "JEE AS: GlassFish (v2.1, v3), OC4J," +
                        " JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, " +
                        "HSQLDB");
        Section experience = new CompanySection("Experience",
                new Company("Yota", "www.yota.com", new Company.Period(DateUtil.of(2020, Month.JULY),
                        DateUtil.of(2020, Month.OCTOBER), "Middle backend developer", "456")),
                new Company("Wrike", "www.wrike.com", new Company.Period(DateUtil.of(2020, Month.JANUARY),
                        DateUtil.of(2020, Month.JULY), "Middle backend developer", "123")));
        Section education = new CompanySection("Education",
                new Company("Coursera", "www.coursera.com", new Company.Period(DateUtil.of(2019, Month.JULY),
                        DateUtil.of(2019, Month.OCTOBER), null, "456")),
                new Company("Luxoft", "www.luxoft.com", new Company.Period(DateUtil.of(2019, Month.JANUARY),
                        DateUtil.of(2019, Month.JULY), null, "123")));

        fillSections(resume, objective, personal, achievements, qualifications, experience, education);
        return resume;
    }

    private void fillContacts(Resume resume, String phone, String skype, String email, String linkedIn, String gitHub
            , String stackOverflow) {
        resume.setContact(ContactType.PHONE, phone);
        resume.setContact(ContactType.SKYPE, skype);
        resume.setContact(ContactType.EMAIL, email);
        resume.setContact(ContactType.LINKEDIN, linkedIn);
        resume.setContact(ContactType.GITHUB, gitHub);
        resume.setContact(ContactType.STACKOVERFLOW, stackOverflow);
    }

    private void fillSections(Resume resume, Section objective, Section personal, Section achievements
            , Section qualifications, Section experience, Section education) {
        resume.setSection(SectionType.OBJECTIVE, objective);
        resume.setSection(SectionType.PERSONAL, personal);
        resume.setSection(SectionType.ACHIEVEMENT, achievements);
        resume.setSection(SectionType.QUALIFICATIONS, qualifications);
        resume.setSection(SectionType.EXPERIENCE, experience);
        resume.setSection(SectionType.EDUCATION, education);
    }
}
