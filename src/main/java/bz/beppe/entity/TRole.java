package bz.beppe.entity;

public class TRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.role_name
     *
     * @mbg.generated
     */
    private String roleName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.id
     *
     * @return the value of t_role.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.id
     *
     * @param id the value for t_role.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.role_name
     *
     * @return the value of t_role.role_name
     *
     * @mbg.generated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.role_name
     *
     * @param roleName the value for t_role.role_name
     *
     * @mbg.generated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}