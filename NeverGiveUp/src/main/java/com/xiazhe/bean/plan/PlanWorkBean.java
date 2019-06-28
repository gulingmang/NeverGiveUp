package com.xiazhe.bean.plan;

import com.xiazhe.bean.Device;
import com.xiazhe.bean.Process;
import com.xiazhe.bean.Product;

public class PlanWorkBean {
   private String workId ;
   private String processNumber ;
   private Product product;
   private Process process;
   private Device device;
   private int rating;

   public PlanWorkBean() {
   }

   public PlanWorkBean(String workId, String processNumber, Product product, Process process, Device device, int rating) {
      this.workId = workId;
      this.processNumber = processNumber;
      this.product = product;
      this.process = process;
      this.device = device;
      this.rating = rating;
   }

   public String getWorkId() {
      return workId;
   }

   public void setWorkId(String workId) {
      this.workId = workId;
   }

   public String getProcessNumber() {
      return processNumber;
   }

   public void setProcessNumber(String processNumber) {
      this.processNumber = processNumber;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public Process getProcess() {
      return process;
   }

   public void setProcess(Process process) {
      this.process = process;
   }

   public Device getDevice() {
      return device;
   }

   public void setDevice(Device device) {
      this.device = device;
   }

   public int getRating() {
      return rating;
   }

   public void setRating(int rating) {
      this.rating = rating;
   }
}
