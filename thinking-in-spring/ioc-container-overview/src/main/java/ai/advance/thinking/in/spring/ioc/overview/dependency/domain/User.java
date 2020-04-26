package ai.advance.thinking.in.spring.ioc.overview.dependency.domain;

/**
 * @author xy
 * @version 1.0
 * @className User
 * @description 用户类
 * @date 2020/4/26 23:00
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
