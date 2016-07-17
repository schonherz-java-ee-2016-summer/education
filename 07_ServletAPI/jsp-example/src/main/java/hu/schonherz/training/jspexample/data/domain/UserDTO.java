package hu.schonherz.training.jspexample.data.domain;

/**
 * Data transfer object representing a user in the database.
 */
public class UserDTO {
    private long id;
    private String name;
    private String password;

    public UserDTO() {
    }

    public UserDTO(final long id, final String name, final String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDTO userDTO = (UserDTO) o;

        if (getId() != userDTO.getId()) {
            return false;
        }

        if (getName() != null ? !getName().equals(userDTO.getName()) : userDTO.getName() != null) {
            return false;
        }

        return getPassword() != null ? getPassword().equals(userDTO.getPassword()) : userDTO.getPassword() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
