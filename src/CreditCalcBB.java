

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CreditCalcBB {
	private Double inter;
	private Double val;
	private Integer years;
	private Double result;

	@Inject
	FacesContext ctx;

	public Double getInter() {
		return inter;
	}


	public void setInter(Double inter) {
		this.inter = inter;
	}


	public Double getVal() {
		return val;
	}


	public void setVal(Double val) {
		this.val = val;
	}


	public Integer getYears() {
		return years;
	}


	public void setYears(Integer years) {
		this.years = years;
	}


	public Double getResult() {
		return result;
	}


	public boolean doTheMath() {
		try {
			
			inter = inter*0.01; 
			result = (val+val*inter)/(years*12); 
			
			return true;
			
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, wrong parameters", null));
			return false;
		}
	}

	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}
}
