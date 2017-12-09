package com.fangxin.siwei.fangzhi;

import com.fangxin.siwei.fangzhi.modal.SwPurchaseDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FangzhiApplicationTests {

	//@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		SwPurchaseDetail swPurchaseDetail=new SwPurchaseDetail();
		swPurchaseDetail.setPurSeqNo("1");
		SwPurchaseDetail swPurchaseDetail1=new SwPurchaseDetail();
		swPurchaseDetail1.setPurSeqNo("2");
		SwPurchaseDetail swPurchaseDetail2=new SwPurchaseDetail();
		swPurchaseDetail2.setPurSeqNo(null);
		SwPurchaseDetail swPurchaseDetail3=new SwPurchaseDetail();
		swPurchaseDetail3.setPurSeqNo(null);
		List<SwPurchaseDetail> testList=new ArrayList<SwPurchaseDetail>();
		testList.add(swPurchaseDetail);
		testList.add(swPurchaseDetail1);
		testList.add(swPurchaseDetail2);
		testList.add(swPurchaseDetail3);
		Collections.sort(testList, new Comparator<SwPurchaseDetail>() {
			@Override
			public int compare(SwPurchaseDetail o1, SwPurchaseDetail o2) {
				return o1.getPurSeqNo().compareTo(o2.getPurSeqNo());
			}
		});
		for(SwPurchaseDetail swPurchaseDetail0:testList){
			System.err.println(swPurchaseDetail0.getPurSeqNo());
		}
	}

}
