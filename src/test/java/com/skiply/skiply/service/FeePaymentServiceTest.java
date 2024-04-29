package com.skiply.skiply.service;

import com.skiply.skiply.entity.Receipt;
import com.skiply.skiply.entity.Student;
import com.skiply.skiply.repository.ReceiptRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FeePaymentServiceTest {

    @Mock
    ReceiptRepository repository;

    @InjectMocks
    FeePaymentServiceImpl feePaymentService;

    @Test
    public void viewReceipt(){
        Integer studentId= 1;
        Receipt receipt = new Receipt();
        receipt.setId(1);
        receipt.setAmount(10.00);
        receipt.setCardNo("12345");
        Mockito.when(repository.findById(studentId)).thenReturn(Optional.of(receipt));
        Receipt rec =  feePaymentService.viewReceipt(receipt.getId());
        assertNotNull(rec);
    }

    @Test
    public void saveReceipt(){

        Receipt receipt = new Receipt();
        receipt.setId(1);
        receipt.setAmount(10.00);
        receipt.setCardNo("12345");
        Mockito.when(repository.save(receipt)).thenReturn(receipt);
        Receipt receipt1 = feePaymentService.payFee(receipt);
        assertNotNull(receipt1);

    }
}
