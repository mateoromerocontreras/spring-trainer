package com.springtrainer.domain.tenant;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
@Table(name = "gym_tenants")
public class GymTenant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String tenantCode;
	
	private String gymName;
	
	private String subDomain;
	
	 @Column(name = "slot_booking_enabled", nullable = false)
     private boolean slotBookingEnabled = true;

     @Column(name = "cancellation_window_hours", nullable = false)
     private int cancellationWindowHours = 24;

     @Column(name = "monthly_debt_cutoff_day", nullable = false)
     private int monthlyDebtCutoffDay = 10;

     @Column(name = "is_active", nullable = false)
     private boolean isActive = true;

     @Column(name = "created_at", nullable = false, updatable = false)
     private Instant createdAt = Instant.now();

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getTenantCode() {
		 return tenantCode;
	 }

	 public void setTenantCode(String tenantCode) {
		 this.tenantCode = tenantCode;
	 }

	 public String getGymName() {
		 return gymName;
	 }

	 public void setGymName(String gymName) {
		 this.gymName = gymName;
	 }

	 public String getSubDomain() {
		 return subDomain;
	 }

	 public void setSubDomain(String subDomain) {
		 this.subDomain = subDomain;
	 }

	 public boolean isSlotBookingEnabled() {
		 return slotBookingEnabled;
	 }

	 public void setSlotBookingEnabled(boolean slotBookingEnabled) {
		 this.slotBookingEnabled = slotBookingEnabled;
	 }

	 public int getCancellationWindowHours() {
		 return cancellationWindowHours;
	 }

	 public void setCancellationWindowHours(int cancellationWindowHours) {
		 this.cancellationWindowHours = cancellationWindowHours;
	 }

	 public int getMonthlyDebtCutoffDay() {
		 return monthlyDebtCutoffDay;
	 }

	 public void setMonthlyDebtCutoffDay(int monthlyDebtCutoffDay) {
		 this.monthlyDebtCutoffDay = monthlyDebtCutoffDay;
	 }

	 public boolean isActive() {
		 return isActive;
	 }

	 public void setActive(boolean isActive) {
		 this.isActive = isActive;
	 }

	 public Instant getCreatedAt() {
		 return createdAt;
	 }

	 public void setCreatedAt(Instant createdAt) {
		 this.createdAt = createdAt;
	 }
 }
