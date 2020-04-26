package ai.advance.thinking.in.spring.ioc.overview.dependency.domain;

import ai.advance.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @author xy
 * @version 1.0
 * @className SuperUser
 * @description
 * @date 2020/4/26 23:23
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
