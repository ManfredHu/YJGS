package com.yjgs.bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspWriter;

import com.yjgs.bll.ibll.IPermissionManageBll;
import com.yjgs.dal.ManagerDal;
import com.yjgs.dal.Manager_PermissionDal;
import com.yjgs.dal.PermissionApplyDal;
import com.yjgs.dal.PermissionDal;
import com.yjgs.dal.Permission_ApplyDal;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.Mapping_Manager_Permission;
import com.yjgs.dcl.Mapping_Permission_Apply;
import com.yjgs.dcl.Permission;
import com.yjgs.dcl.PermissionApply;

public class PermissionManageBll implements IPermissionManageBll {

	@Override
	public boolean registerNewManager(Manager fManager,
			ArrayList<Permission> fPermissions) {

		ManagerDal mDal = null;
		Manager_PermissionDal mpDal = null;
		ArrayList<Mapping_Manager_Permission> mapPermissions = null;

		// 步骤1：添加Manager信息，并返回数据库Manager记录的ID
		// -----------------------------------------------------------------
		try {

			// 添加Manager信息
			mDal = new ManagerDal();
			if (!mDal.addManager(fManager))
				return false;

			// 获取Manager的ID
			fManager = mDal.getManagerID(fManager);
			if (fManager == null)
				return false;

		} catch (Exception e) {

			System.out.println("业务逻辑层：Manager信息的添加出错");
			e.printStackTrace();
		}

		// 步骤2：根据获取的Manager的ID，封装权限映射数据并添加到数据库
		//---------------------------------------------------------------------------
		try {

			// 封装映射数据
			mapPermissions = new ArrayList<Mapping_Manager_Permission>();
			for (Permission aPermission : fPermissions) {

				Mapping_Manager_Permission aMapPermission = new Mapping_Manager_Permission();

				aMapPermission.setManagerID(fManager.getManagerID());
				aMapPermission.setPermission(aPermission.getContent());

				mapPermissions.add(aMapPermission);
			}

			// 调用Dal添加到数据库
			mpDal = new Manager_PermissionDal();
			if (!mpDal.addNewPermissions(mapPermissions))
				return false;

		} catch (Exception e) {

			System.out.println("业务逻辑层：权限映射集合添加时异常");
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public void loadAllPermission(JspWriter fOut) {

		PermissionDal pDal = null;
		ArrayList<Permission> permissions = null;

		// 步骤1：实例化并调用权限数据层，获取所有权限信息
		pDal = new PermissionDal();
		permissions = pDal.getAllPermission();

		// 步骤2：遍历权限数据集合，输出对应的复选框选项
		try {

			// 如果获取的权限数据为空，抛出异常
			if (permissions == null)
				throw new Exception("无法从数据层获取系统权限数据！");

			for (Permission aPermission : permissions) {

				fOut.println(String
						.format("<dd><input type='checkbox' value=%s name='permissions' />%s</dd>",
								aPermission.getContent(),
								aPermission.getContent()));
			}
		} catch (Exception e) {
			System.out.println("添加管理员：权限数据加载异常！");
			e.printStackTrace();
		}

	}
	
	@Override
	public void loadAllManager(JspWriter fOut) {

		ManagerDal mDal = null;
		Manager_PermissionDal mpDal = null;
		ArrayList<Manager> managers = null;
		
		try {
			
			//步骤1：实例化数据操作层
			mDal = new ManagerDal();
			mpDal = new Manager_PermissionDal();
			
			//步骤2：获取所有管理员数据集合
			managers = mDal.selectAllManager();
			if(managers == null) return;
			
			//步骤3：遍历管理员集合
			for(Manager aManager : managers) {
				
				//步骤3.1：获取当前管理员所有权限
				Mapping_Manager_Permission managerID = 
						new Mapping_Manager_Permission();
				managerID.setManagerID(aManager.getManagerID());
				ArrayList<Mapping_Manager_Permission> permissions =
						mpDal.getAllPermission(managerID);
				
				
				//步骤3.2：输出用户名及账号
				fOut.println(String.format("<tr>"
						+ "<td>%s</td>"
						+ "<td>%s</td>"
						+ "<td>"
						, aManager.getManagerName(),aManager.getManagerAccount()));
				
				//步骤3.3：加载权限选择，并绑定管理员权限情况
				//---------------------------------------------------
				
				
				//权限：产品管理
				{
					boolean isHas = false;
					for(Mapping_Manager_Permission aPermission : permissions) {
						
						if(aPermission.getPermission().equals("产品管理")) {
							
							isHas = true;
							break;
						}
					}
					fOut.println(String.format("<div><input class='pad' type='checkbox' "
							+ "value=产品管理 %s name=permission:%s />产品管理</div>"
							,isHas? "checked='checked'":"",aManager.getManagerID()));
				}
				
				//权限：新闻管理
				{
					boolean isHas = false;
					for(Mapping_Manager_Permission aPermission : permissions) {
						
						if(aPermission.getPermission().equals("新闻管理")) {
							
							isHas = true;
							break;
						}
					}
					fOut.println(String.format("<div><input class='pad' type='checkbox' "
							+ "value=新闻管理 %s name=permission:%s />新闻管理</div>"
							,isHas? "checked='checked'":"",aManager.getManagerID()));
				}
				
				//权限：首页管理
				{
					boolean isHas = false;
					for(Mapping_Manager_Permission aPermission : permissions) {
						
						if(aPermission.getPermission().equals("首页管理")) {
							
							isHas = true;
							break;
						}
					}
					fOut.println(String.format("<div><input class='pad' type='checkbox' "
							+ "value=首页管理 %s name=permission:%s />首页管理</div>"
							,isHas? "checked='checked'":"",aManager.getManagerID()));
				}
				
				//权限：反馈管理
				{
					boolean isHas = false;
					for(Mapping_Manager_Permission aPermission : permissions) {
						
						if(aPermission.getPermission().equals("反馈管理")) {
							
							isHas = true;
							break;
						}
					}
					fOut.println(String.format("<div><input class='pad' type='checkbox' "
							+ "value=反馈管理 %s name=permission:%s />反馈管理</div>"
							,isHas? "checked='checked'":"",aManager.getManagerID()));
				}
				
				//权限：企业信息管理
				{
					boolean isHas = false;
					for(Mapping_Manager_Permission aPermission : permissions) {
						
						if(aPermission.getPermission().equals("企业信息管理")) {
							
							isHas = true;
							break;
						}
					}
					fOut.println(String.format("<div><input class='pad' type='checkbox' "
							+ "value=企业信息管理 %s name=permission:%s />企业信息管理</div>"
							,isHas? "checked='checked'":"",aManager.getManagerID()));
				}
				
				//权限：功能管理
				{
					boolean isHas = false;
					for(Mapping_Manager_Permission aPermission : permissions) {
						
						if(aPermission.getPermission().equals("功能管理")) {
							
							isHas = true;
							break;
						}
					}
					fOut.println(String.format("<div><input class='pad' type='checkbox' "
							+ "value=功能管理 %s name=permission:%s />功能管理"
							,isHas? "checked='checked'":"",aManager.getManagerID()));
				}
				
				//步骤步骤3.4：输出删除链接
				fOut.println(String.format("</td>"
						+ "<td><a href='DeleteManager?ID=%s'>删除</a></td>"
						, aManager.getManagerID()));
				

				//隐藏表单：（用户保证始终可以读取用户ID）
				{
					fOut.println(String.format("<div><input class='pad' type='checkbox' "
							+ "value=隐藏表单 checked='checked' name=permission:%s "
							+ " style='display:none;height:1px;' /></div>"
							,aManager.getManagerID()));
				}
				
			}
			
		} catch (Exception e) {
			
			System.out.println("管理员列表加载出错！");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 删除一个管理员的所有信息
	 * 
	 * @param fManager	所要删除的管理员
	 * @return					返回是否删除成功
	 */
	public boolean DeleteManager(Manager fManager) {
		
		ManagerDal mDal = null;
		Manager_PermissionDal mpDal = null;
		Mapping_Manager_Permission permission = null;
		
		//步骤1：将ManagerID包装到映射实体类中
		permission = new Mapping_Manager_Permission();
		permission.setManagerID(fManager.getManagerID());
		
		//步骤2：实例化Dal类
		mDal = new ManagerDal();
		mpDal = new Manager_PermissionDal();
		
		try {
			
			mpDal.deleteAllPermission(permission);
			if(!mDal.deleteManager(fManager)) return false;
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：管理员删除异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean modifyPermission(Map<Manager, 
			ArrayList<Mapping_Manager_Permission>> fMapManagers) {

		Manager_PermissionDal mpDal = null;
		Manager[] keys = null;
		
		mpDal = new Manager_PermissionDal();
		
		try {
			
			//步骤1：获取Map中的Key值（即Manager数组）
			Set<Manager> aSet = fMapManagers.keySet();
			keys = aSet.toArray(new Manager[aSet.size()]);
			
			//步骤2：遍历Keys对每个管理进行修改
			for(Manager aKey : keys) {
				
				//步骤2.1：删除管理员原有的所有权限
				Mapping_Manager_Permission aManager
				= new Mapping_Manager_Permission();
				aManager.setManagerID(aKey.getManagerID());
				if(!mpDal.deleteAllPermission(aManager)) {
					
					throw new Exception("原有权限删除异常");
				}
				
				//步骤2.2：获取对应value（权限映射集合）
				ArrayList<Mapping_Manager_Permission> 
				permissions = fMapManagers.get(aKey);
				
				//步骤2.3：添加新的权限
				if(permissions.size() == 0) continue;		//若没有选择任何权限，跳过当前循环
				if(!mpDal.addNewPermissions(permissions)) {
					
					throw new Exception("新的权限添加异常");
				}
			}
		} 
		catch (Exception e) {
			
			System.out.println("业务逻辑层：权限修改异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public void loadNoReadApplies(JspWriter fOut){

		ManagerDal mDal = null;
		PermissionApplyDal paDal = null; 
		Permission_ApplyDal mpaDal = null;
		ArrayList<PermissionApply> applies = null;
		
		//步骤1：实例化DAL
		mDal = new ManagerDal();
		paDal = new PermissionApplyDal();
		mpaDal = new Permission_ApplyDal();
		
		
		try {
			
			//步骤2：调用DAL获取所有未读申请
			applies = paDal.getNoReadApplies();
			if(applies == null) return;
			
			//步骤3：遍历所有未读申请，输出数据
			
			//设置日期格式
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			for(PermissionApply aApply : applies) {
				
				//步骤3.1：获取当前管理员的信息
				Manager aManager = new Manager();
				aManager.setManagerID(aApply.getManagerID());
				aManager = mDal.getAManager(aManager);
				
				//步骤3.2：输出管理员信息
				fOut.println("<tr>");
				fOut.println(String.format("<td>%s</td>", aManager.getManagerName()));
				fOut.println(String.format("<td>%s</td>", aManager.getManagerAccount()));
				
				//步骤3.3：输出申请日期
				fOut.println(String.format("<td>%s</td>", sdf.format(aApply.getApplyTime())));
				
				//步骤3.4：获取当前申请的权限
				Mapping_Permission_Apply mapApply 
				= new Mapping_Permission_Apply();
				mapApply.setPerApplyID(aApply.getPerApplyID());
				ArrayList<Mapping_Permission_Apply> permissions
				= mpaDal.getAllPermissions(mapApply);
				
				//步骤3.5：遍历申请的权限，并输出
				fOut.println("<td>");
				for(Mapping_Permission_Apply aPermission : permissions) {
					
					fOut.println(String.format("<span>%s </span>", aPermission.getPermission()));
				}
				fOut.println("</td>");
				
				//步骤3.6：输出是否通过的链接
				fOut.println("<td>");
				fOut.println(String.format("<a href='ApplyDeal?ID=%d&Type=true' >通过</a> "
						,aApply.getPerApplyID()));
				fOut.println(String.format("<a href='ApplyDeal?ID=%d&Type=false' >不通过</a>"
						,aApply.getPerApplyID()));
				fOut.println("</td>");
			}
		} 
		catch (Exception e) {

			System.out.println("业务逻辑层：加载未读权限出错");
			e.printStackTrace();
		}
	}

	@Override
	public void loadReadedApplies(JspWriter fOut) {

		ManagerDal mDal = null;
		PermissionApplyDal paDal = null; 
		Permission_ApplyDal mpaDal = null;
		ArrayList<PermissionApply> applies = null;
		
		//步骤1：实例化DAL
		mDal = new ManagerDal();
		paDal = new PermissionApplyDal();
		mpaDal = new Permission_ApplyDal();
		
		
		try {
			
			//步骤2：调用DAL获取所有已读申请
			applies = paDal.getReadedApplies();
			if(applies == null) return;
			
			//步骤3：遍历所有未读申请，输出数据
			
			//设置日期格式
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			for(PermissionApply aApply : applies) {
				
				//步骤3.1：获取当前管理员的信息
				Manager aManager = new Manager();
				aManager.setManagerID(aApply.getManagerID());
				aManager = mDal.getAManager(aManager);
				
				//步骤3.2：输出管理员信息
				fOut.println("<tr>");
				fOut.println(String.format("<td>%s</td>", aManager.getManagerName()));
				fOut.println(String.format("<td>%s</td>", aManager.getManagerAccount()));
				
				//步骤3.3：输出申请日期
				fOut.println(String.format("<td>%s</td>", sdf.format(aApply.getApplyTime())));
				
				//步骤3.4：获取当前申请的权限
				Mapping_Permission_Apply mapApply 
				= new Mapping_Permission_Apply();
				mapApply.setPerApplyID(aApply.getPerApplyID());
				ArrayList<Mapping_Permission_Apply> permissions
				= mpaDal.getAllPermissions(mapApply);
				
				//步骤3.5：遍历申请的权限，并输出
				fOut.println("<td>");
				for(Mapping_Permission_Apply aPermission : permissions) {
					
					fOut.println(String.format("<span>%s </span>", aPermission.getPermission()));
				}
				fOut.println("</td>");
				
				//步骤3.6：输出是否通过信息
				fOut.println(String.format("<td>%s</td>", aApply.isPass()? "通过":"不通过"));
				
				//步骤3.7：输出删除连接
				fOut.println(String.format("<td><a href='DeleteApply?ID=%d'>删除</a></td>", aApply.getPerApplyID()));
			}
		} 
		catch (Exception e) {

			System.out.println("业务逻辑层：加载未读权限出错");
			e.printStackTrace();
		}
	}

	@Override
	public boolean dealApply(PermissionApply fApply) {

		PermissionApplyDal paDal = null;
		Permission_ApplyDal mpaDal = null;
		Manager_PermissionDal mpDal = null;
		
		//步骤1：实例化DAL
		paDal = new PermissionApplyDal();
		mpaDal = new Permission_ApplyDal();
		mpDal = new Manager_PermissionDal();
		
		try {
			
			//步骤2：更新申请数据
			if(!paDal.updateApply(fApply)) return false;
			
			//步骤3：判断是否通过申请，不通过则退出方法
			if(!fApply.isPass()) return true;
			
			//步骤4：获取申请的所有权限
			ArrayList<Mapping_Permission_Apply> applyPermissions = null;
			Mapping_Permission_Apply applyID 
			= new Mapping_Permission_Apply();
			applyID.setPerApplyID(fApply.getPerApplyID());
			applyPermissions = mpaDal.getAllPermissions(applyID);
			
			//步骤5：获取管理员ID
			fApply = paDal.getApply(fApply);
			
			//步骤6：构造管理员权限映射数据
			ArrayList<Mapping_Manager_Permission> permissions =
					new ArrayList<Mapping_Manager_Permission>();
			for(Mapping_Permission_Apply aApplyPer : applyPermissions) {
				
				Mapping_Manager_Permission aPermission
				= new Mapping_Manager_Permission();
				
				aPermission.setManagerID(fApply.getManagerID());
				aPermission.setPermission(aApplyPer.getPermission());
				
				permissions.add(aPermission);
			}
			
			//步骤7：调用DAL添加管理员权限映射数据
			if(!mpDal.addNewPermissions(permissions)) return false;

		}
		catch (Exception e) {

			System.out.println("业务逻辑层：处理权限申请时出错");
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean deleteApply(PermissionApply fApply) {

		PermissionApplyDal paDal = null;
		Permission_ApplyDal mpaDal = null;
		
		// 步骤1：实例化DAL
		paDal = new PermissionApplyDal();
		mpaDal = new Permission_ApplyDal();
		
		try {
			
			//步骤1：删除申请对应的所有权限
			Mapping_Permission_Apply applyID
			= new Mapping_Permission_Apply();
			applyID.setPerApplyID(fApply.getPerApplyID());
			if(!mpaDal.deleteAllPermission(applyID)) return false;
			
			//步骤2：删除申请
			if(!paDal.deleteApplies(fApply)) return false;
			
		}
		catch (Exception e) {

			System.out.println("业务逻辑层：删除申请出错");
			e.printStackTrace();
		}

		return true;
	}

}
