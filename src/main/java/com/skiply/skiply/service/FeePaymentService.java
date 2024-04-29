package com.skiply.skiply.service;

import com.skiply.skiply.entity.Receipt;

public interface FeePaymentService {

    Receipt payFee(Receipt receipt);

    Receipt viewReceipt(Integer id);
}
