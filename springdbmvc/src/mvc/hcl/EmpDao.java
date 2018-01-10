package mvc.hcl;  //package name

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  

import com.mysql.jdbc.ResultSet;

import mvc.hcl.Emp;
public class EmpDao 
{
	JdbcTemplate template;          //user defined jdbctemplate  for jdbc operations

	public void setTemplate(JdbcTemplate template)    //setter method for jdbctemplate reference
	{
		this.template = template;
	}
	
	public int save(Emp p)   //save method to save the employee details
	{  
	    String sql="insert into Employee(name,salary)values('"+p.getName()+"','"+p.getSalary()+"')";  
	    return template.update(sql);  
	}  
	
	public int update(Emp p)  //update method to update the employee details
	{  
	    String sql="update Employee set name='"+p.getName()+"', salary="+p.getSalary()+" where id="+p.getId()+"";  
	    return template.update(sql);  
	}  
	
	
	public int delete(int id) //delete method to delete the employee details
	{  
	    String sql="delete from Employee where id="+id+"";  
	    return template.update(sql);  
	}  
	
	public Emp getEmpById(int id)  //getEmpById method to read the employee details from the database
	{  
	    String sql="select * from Employee where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
	}  
	

	public List<Emp> getEmployees()  //process for getting the employee details
	{  
	    return template.query("select * from Employee",new RowMapper<Emp>()
	     {  
			@Override
			public Emp mapRow(java.sql.ResultSet rs, int arg1)
					throws SQLException {
				 Emp e=new Emp();  
		            e.setId(rs.getInt(1));  //set employee id and get the details from the database using resultset object
		            e.setName(rs.getString(2));  //set employee name and get the details from the database using resultset object
		            e.setSalary(rs.getFloat(3));  //set employee salary and get the details from the database using resultset object
		            return e;            //returning the employee object
			}
	      });  
	}  	
}
