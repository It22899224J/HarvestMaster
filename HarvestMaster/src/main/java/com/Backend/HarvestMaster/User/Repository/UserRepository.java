package com.Backend.HarvestMaster.User.Repository;

import com.Backend.HarvestMaster.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
