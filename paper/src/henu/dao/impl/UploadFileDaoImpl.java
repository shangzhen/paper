package henu.dao.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.UploadFile;
import henu.dao.IUploadFileDao;


public class UploadFileDaoImpl implements IUploadFileDao {
	
    private  QueryRunner queryRunner;
	
	public UploadFileDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
/**
 * 添加上传文件
 * 	fTitle 标题
 *	fPublisher  发布人
	fUpTime  上传时间
	fFilePath 上传路径
	fRemark 备注
 */
	@Override
	
	public int add(UploadFile file) {
				
		String sql="INSERT INTO t_file(fTitle,fPublisher,fUpTime,fFilePath,fRemark,fName) VALUES(?,?,?,?,?,?)";
		Object[] params ={file.getFtitle(),file.getFpublisher(),file.getFupTime(),file.getFfilePath(),file.getFremark(),file.getFname()};
		int result =0;
		 	try {
				result = queryRunner.update(sql,params);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return result;
	}
	/**
	 * 添加上传文件
	 * 	fTitle 标题
	 *	fPublisher  发布人
		fUpTime  上传时间
		fFilePath 上传路径
		fRemark 备注
	 */
	
	@Override//更新
	public int update(int fid, UploadFile file) {
		// TODO Auto-generated method stub
		String sql="UPDATE t_file SET ftitle=?,fpublisher=?,fupTime=?,ffilePath=?,fremark=?,fName=? WHERE fid=?";
		Object[]params={file.getFtitle(),file.getFpublisher(),file.getFupTime(),file.getFfilePath(),file.getFremark(),file.getFname(),fid};
		
		int result = 0;
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override//更具fid删除用户
	public int delete(int fid) {
		
		String sql="DELETE from t_file WHERE fid=?";
		int result = 0;
		try {
			result =queryRunner.update(sql,fid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	/**
	 *  查看上传文件
	 * 	fTitle 标题
	 *	fPublisher  发布人
		fUpTime  上传时间
		fFilePath 上传路径
		fRemark 备注
	 */
	@Override
	public UploadFile find(int fid) {
		
		String sql="SELECT * from t_file WHERE fid=?";
		Object[] params = {fid};
		UploadFile file=null;
		
		try {
			file=queryRunner.query(sql, new BeanHandler<UploadFile>(UploadFile.class),params);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return file;
	}
	/**
	 * 添加上传文件
	 * 	fTitle 标题
	 *	fPublisher  发布人
		fUpTime  上传时间
		fFilePath 上传路径
		fRemark 备注
	 */
	@Override
	public List<UploadFile> findAll() {
		
		String 	sql = "SELECT * FROM t_file ORDER BY fid DESC";
		List<UploadFile> list=null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<UploadFile>(UploadFile.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 添加上传文件
	 * 	fTitle 标题
	 *	fPublisher  发布人
		fUpTime  上传时间
		fFilePath 上传路径
		fRemark 备注
	 */
	@Override
	public List<UploadFile> findByProperty(String property, String key, String order,String sort, int start, int end) {
		String sql = "SELECT * FROM t_file WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
			
			List<UploadFile> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<UploadFile>(UploadFile.class));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return list;
	}
		
	
}








