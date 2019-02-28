package com.lti.servlet;

public class Snippet {
	<form>
	    From :
	    <select [(ngModel)]="fromCurrency" name="Currency">
	    
	        <option value="INR">Indian Rupee</option>
	        <option value="USD">US Dollars</option>
	        <option value="GBP">Great Britian Pound</option>
	        
	    </select>
	    To :
	    <select [(ngModel)]="toCurrency" name="Currency">
	        
	        <option value="INR">Indian Rupee</option>
	        <option value="USD">US Dollars</option>
	        <option value="GBP">Great Britian Pound</option>
	    </select>
	    Amount :
	    <input [(ngModel)]="amount" type="text" name="amount" />
	    <!--ng model proviodes two way binding-->
	    <button (click)="convert()">Convert</button>
	    <p>
	        result is
	    </p> {{ result }}
	    <!--one way binding-->
	</form>
}

