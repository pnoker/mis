package com.noker.mis.model;

import java.io.Serializable;

public class Manger implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manger.manger_name
     *
     * @mbggenerated
     */
    private String mangerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manger.manger_password
     *
     * @mbggenerated
     */
    private String mangerPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manger
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manger.manger_name
     *
     * @return the value of manger.manger_name
     *
     * @mbggenerated
     */
    public String getMangerName() {
        return mangerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manger.manger_name
     *
     * @param mangerName the value for manger.manger_name
     *
     * @mbggenerated
     */
    public void setMangerName(String mangerName) {
        this.mangerName = mangerName == null ? null : mangerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manger.manger_password
     *
     * @return the value of manger.manger_password
     *
     * @mbggenerated
     */
    public String getMangerPassword() {
        return mangerPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manger.manger_password
     *
     * @param mangerPassword the value for manger.manger_password
     *
     * @mbggenerated
     */
    public void setMangerPassword(String mangerPassword) {
        this.mangerPassword = mangerPassword == null ? null : mangerPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manger
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Manger other = (Manger) that;
        return (this.getMangerName() == null ? other.getMangerName() == null : this.getMangerName().equals(other.getMangerName()))
            && (this.getMangerPassword() == null ? other.getMangerPassword() == null : this.getMangerPassword().equals(other.getMangerPassword()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manger
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMangerName() == null) ? 0 : getMangerName().hashCode());
        result = prime * result + ((getMangerPassword() == null) ? 0 : getMangerPassword().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manger
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mangerName=").append(mangerName);
        sb.append(", mangerPassword=").append(mangerPassword);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}