package org.spring.testbook.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.spring.testbook.entity.Student;

import java.util.List;


@Mapper
public interface StudentMapper {

    /**
     *
     * @return 返回关于student表的所以信息
     * <p>
     *     int id
     *     String name
     *     String sex
     *     int age
     *     String grade
     * </p>
     */
    @Select("select * from student")
    List<Student> selectAllStudent();

    @Select("SELECT COUNT(*) FROM student")
    int countStudents();

    @Insert("insert into student(name, sex, age, grade) values(#{name},#{sex},#{age},#{grade})")
    int insertStudent(@Param("name")String name,@Param("sex") String sex,@Param("age") int age,@Param("grade") String grade);
}
