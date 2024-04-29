package com.skiply.skiply.repository;

import com.skiply.skiply.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt,Integer> {

}
