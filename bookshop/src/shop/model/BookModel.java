package shop.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import shop.domain.Book;
import shop.utils.JDBCUtils;

public class BookModel {

	public List<Book> findAll() throws SQLException {
		String sql = "select * from book";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Book> bookList = queryRunner.query(sql, new BeanListHandler<Book>(Book.class));
		return bookList;
	}

	public boolean checkBookNameRepeat(Book book) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "SELECT * FROM book WHERE bookName = ? ";
		Book exsitBook = queryRunner.query(sql, new BeanHandler<Book>(Book.class), book.getBookName());
		if (exsitBook == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean addBook(Book book) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "INSERT INTO `bookshop`.`book`(`bookName`, `bookType`, `bookNote`, `author`, `price`) VALUES (?, ?, ?, ?, ?);";
		int num = queryRunner.execute(sql, book.getBookName(), book.getBookType(), book.getBookNote(), book.getAuthor(),
				book.getPrice());
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Book getBook(Book book) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "SELECT * FROM book WHERE id = ? ";
		Book exsitBook = queryRunner.query(sql, new BeanHandler<Book>(Book.class), book.getId());
		return exsitBook;
	}

	public boolean deleteBook(Book book) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "DELETE FROM book WHERE id = ?";
		int num = queryRunner.execute(sql, book.getId());
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}
}
