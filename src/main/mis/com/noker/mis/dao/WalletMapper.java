package com.noker.mis.dao;

import com.noker.mis.model.Wallet;

public interface WalletMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wallet
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String phone);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wallet
     *
     * @mbggenerated
     */
    int insert(Wallet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wallet
     *
     * @mbggenerated
     */
    int insertSelective(Wallet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wallet
     *
     * @mbggenerated
     */
    Wallet selectByPrimaryKey(String phone);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wallet
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Wallet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wallet
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Wallet record);
}