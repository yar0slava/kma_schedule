package com.example.kma_schedule.config;
import com.example.kma_schedule.database.entity.*;
import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.database.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.Optional;

@Configuration
@ComponentScan
@EnableConfigurationProperties(DatabaseProperties.class)
public class AppConfiguration {

    @Autowired
    private DatabaseProperties databaseProperties;

    @Bean
    DisciplineRepository disciplineRepository(){
        return new DisciplineRepository() {
            @Override
            public <S extends Discipline> S save(S s) {
                return null;
            }

            @Override
            public <S extends Discipline> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Discipline> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<Discipline> findAll() {
                return null;
            }

            @Override
            public Iterable<Discipline> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }


            @Override
            public void deleteById(Integer integer) {}

            @Override
            public void delete(Discipline discipline) {}

            @Override
            public void deleteAllById(Iterable<? extends Integer> iterable) {}

            @Override
            public void deleteAll(Iterable<? extends Discipline> iterable) {}

            @Override
            public void deleteAll() {}
        };
    }

    @Bean
    LecturerRepository lecturerRepository(){
        return new LecturerRepository() {
            @Override
            public <S extends Lecturer> S save(S s) {
                return null;
            }

            @Override
            public <S extends Lecturer> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Lecturer> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<Lecturer> findAll() {
                return null;
            }

            @Override
            public Iterable<Lecturer> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Lecturer lecturer) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends Lecturer> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }


    @Bean
    ClassroomRepository classroomRepository(){
    return new ClassroomRepository() {
        @Override
        public <S extends Classroom> S save(S s) {
            return null;
        }

        @Override
        public <S extends Classroom> Iterable<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Optional<Classroom> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public Iterable<Classroom> findAll() {
            return null;
        }

        @Override
        public Iterable<Classroom> findAllById(Iterable<Integer> iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Classroom classroom) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> iterable) {

        }

        @Override
        public void deleteAll(Iterable<? extends Classroom> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public Optional<Classroom> findByName(String name) {
            return Optional.empty();
        }
    };
    }

    @Bean
    ClassTimeRepository classTimeRepository(){
        return new ClassTimeRepository() {
            @Override
            public <S extends ClassTime> S save(S s) {
                return null;
            }

            @Override
            public <S extends ClassTime> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<ClassTime> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<ClassTime> findAll() {
                return null;
            }

            @Override
            public Iterable<ClassTime> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(ClassTime classTime) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends ClassTime> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

    @Bean
    GroupRepository groupRepository(){
        return new GroupRepository() {
            @Override
            public List<Group> findByDegree(String degree) {
                return null;
            }

            @Override
            public List<Group> findBySpecialization(String specialization) {
                return null;
            }

            @Override
            public <S extends Group> S save(S s) {
                return null;
            }

            @Override
            public <S extends Group> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Group> findById(String s) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(String s) {
                return false;
            }

            @Override
            public Iterable<Group> findAll() {
                return null;
            }

            @Override
            public Iterable<Group> findAllById(Iterable<String> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(String s) {

            }

            @Override
            public void delete(Group group) {

            }

            @Override
            public void deleteAllById(Iterable<? extends String> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends Group> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

    @Bean
    RecordRepository recordRepository(){
        return new RecordRepository() {
            @Override
            public List<Record> find() {
                return null;
            }

            @Override
            public <S extends Record> S save(S s) {
                return null;
            }

            @Override
            public <S extends Record> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Record> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<Record> findAll() {
                return null;
            }

            @Override
            public Iterable<Record> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Record record) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends Record> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

}