package com.app.controller;

import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
	/*@Autowired
	private ICustomerService service;
	
	@RequestMapping("/reg")
	public String showCReg(ModelMap map) {
		map.addAttribute("cutomer",new Customer());
		return "CutomerReg";
	}
	@RequestMapping("/insert")
	public String saveCData(@ModelAttribute Customer customer,ModelMap map) {
		Integer cId=service.saveCustomer(customer);
		String msg=" customer "+cId+" saved";
		map.addAttribute("message",msg);
		map.addAttribute("customer",new Customer());
		return "CustomerReg";
	}
	@RequestMapping("/all")
	public String getCData(ModelMap map) {
		List<Customer> list=service.getAllCustomers();
		map.addAttribute("list",list);
		return "CutomerData";
	}
	@RequestMapping("/delete")
	public String deleteCCust(@RequestParam("id")Integer cId,ModelMap map) {
		service.deleteCustomer(cId);
		String msg=" Customer "+cId+"Deleted";
		List<Customer> list=service.getAllCustomers();
		map.addAttribute("message",msg);
		map.addAttribute("list",list);
		return "CustomerData";
	}
	@RequestMapping("/edit")
	public String showSEdit(@RequestParam("id")Integer cId,ModelMap map)
	{  
		Customer c=service.getOneCustomer(cId);
        map.addAttribute("c",c);	
		return "CustomerEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
    public String showUpdate(@ModelAttribute Customer customer,ModelMap map) {
    	service.updateCustomer(customer);
    	String msg=" customer"+customer.getCustId()+" updated";
    	List<Customer> list=service.getAllCustomers();
    	map.addAttribute("message",msg);
    	map.addAttribute("list",list);
    	return "CustomerData";
    }
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Customer> cust=service.getAllCustomers();
		ModelAndView m=new ModelAndView();
		m.setView(null);
		m.addObject("cust",cust);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<Customer> cust=service.getAllCustomers();
		ModelAndView m=new ModelAndView();
		m.setView(null);
		m.addObject("cust",cust);
		return m;
	}*/
	
}
	
