package br.com.lemontech.selfbooking.ehtl.model.response;

public class EhtlCancelBookingAttributesRS {

	private String message;
	private boolean canceled;
	private String cancellationPolicies;
	private boolean cancellationPoliciesApplying;
	private String refundStatus;
	
	public EhtlCancelBookingAttributesRS() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isCanceled() {
		return canceled;
	}
	
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public String getCancellationPolicies() {
		return cancellationPolicies;
	}

	public void setCancellationPolicies(String cancellationPolicies) {
		this.cancellationPolicies = cancellationPolicies;
	}

	public boolean isCancellationPoliciesApplying() {
		return cancellationPoliciesApplying;
	}

	public void setCancellationPoliciesApplying(boolean cancellationPoliciesApplying) {
		this.cancellationPoliciesApplying = cancellationPoliciesApplying;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
}
