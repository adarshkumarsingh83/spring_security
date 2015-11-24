package com.espark.adarsh.spring.web.webservice;

import com.espark.adarsh.spring.core.annotation.ResponseView;
import com.espark.adarsh.spring.core.annotation.RestWebService;
import com.espark.adarsh.spring.core.bean.DepartmentViewBean;
import com.espark.adarsh.spring.core.bean.view.DepartmentView;
import com.espark.adarsh.spring.persistence.entities.Department;
import com.espark.adarsh.spring.web.manager.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
@RestWebService
public class DepartmentController {

   @Autowired(required = true)
   private EmployeeManager employeeManager;

    // http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/department/all
    @RequestMapping("/department/all")
    @ResponseView(DepartmentView.class)
    public
    @ResponseBody
    List<DepartmentViewBean> getDepartmentSummaries() {
        final List<Department> departmentList=this.employeeManager.getAllDepartment();
        final List<DepartmentViewBean> departmentViewsList=new ArrayList<DepartmentViewBean>(departmentList.size());
        for(Department department:departmentList){
            departmentViewsList.add(new DepartmentViewBean(department));
        }
        return departmentViewsList;
    }


    // http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/department/{departmentId}
    @RequestMapping("/department/{departmentId}")
    public
    @ResponseBody
    DepartmentViewBean getDepartmentDetail(@PathVariable("departmentId") Integer departmentId) {
        return new DepartmentViewBean(this.employeeManager.getDepartment(departmentId));
    }

}
