

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
	private String inter;
	private String val;
	private String years;
	private Double result;

	@Inject
	FacesContext ctx;

	public String getInter() {
		return inter;
	}


	public void setInter(String inter) {
		this.inter = inter;
	}


	public String getVal() {
		return val;
	}


	public void setVal(String val) {
		this.val = val;
	}


	public String getYears() {
		return years;
	}


	public void setYears(String years) {
		this.years = years;
	}


	public Double getResult() {
		return result;
	}


	public boolean doTheMath() {
		try {
			double years = Double.parseDouble(this.years);
			double inter = Double.parseDouble(this.inter);
			double val = Double.parseDouble(this.val);
			
			if (years < 0 || inter < 0 || val < 0) {
				ctx.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, negative parameters", null));
				return false;
			}
			
			result = (val+val*inter)/(years*12); 
			
			if (result < 0 ) ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, negative parameters", null));
			
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
