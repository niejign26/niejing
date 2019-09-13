package com.bootdo.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bootdo.system.domain.UserDO;

/**
 * Created by nbfujx on 2017-12-08.
 */
public interface UserRepository extends MongoRepository<UserDO, Long> {

    /**
     * Like（模糊查询）
     * {"username" : name} ( name as regex)
     * */
    List<UserDO> findByUsernameLike(String username);

    /**
     * Like（模糊查询）
     * {"username" : name}
     * */
    List<UserDO> findByUsername(String username);


    /**
     * IsNotNull, NotNull（是否非空）
     *  {"username" : {"$ne" : null}}
     * */
    List<UserDO> findByUsernameNotNull();

    /**
     * IsNull, Null（是否为空）
     *   {"username" : null}
     * */
    List<UserDO> findByUsernameNull();


    /**
     * Not（不包含）
     *    {"username" : {"$ne" : name}}
     * */
    List<UserDO> findByUsernameNot(String name);



    /**
     *  Near（查询地理位置相近的）
     *  {"location" : {"$near" : [x,y]}}
     * */
     // findByLocationNear(Point point)


    /**
     * Within（在地理位置范围内的）
     *   {"location" : {"$within" : {"$center" : [ [x, y], distance]}}}
     * */
    //findByLocationWithin(Circle circle)


    /**
     *   Within（在地理位置范围内的）
     *     {"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}
     * */
   // findByLocationWithin(Box box)


    @Query("{\"username\":{\"$regex\":?0}, \"age\": ?1}")
    Page<UserDO> findByNameAndAgeRange(String name,int age,Pageable page);

    @Query(value="{\"username\":{\"$regex\":?0},\"age\":{\"$gte\":?1,\"$lte\": ?2}}")
    Page<UserDO> findByNameAndAgeRange2(String name,int ageFrom,int ageTo,Pageable page);

    @Query(value="{\"username\":{\"$regex\":?0},\"age\":{\"$gte\":?1,\"$lte\": ?2}}",fields="{\"username\" : 1, \"age\" : 1}")
    Page<UserDO> findByNameAndAgeRange3(String name,int ageFrom,int ageTo,Pageable page);

}
