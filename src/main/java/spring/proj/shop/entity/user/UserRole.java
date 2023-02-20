package spring.proj.shop.entity.user;

import lombok.Getter;

public enum UserRole {

    ADMIN("ADMIN"),
    USER("USER");

    private String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return "ROLE_" + name;
    }
}
