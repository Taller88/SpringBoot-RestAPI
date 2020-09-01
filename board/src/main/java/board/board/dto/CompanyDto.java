package board.board.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="CompanyDto: 크롤링 데이터", description = "크롤링 데이터")
public class CompanyDto {
	
	@ApiModelProperty(value="주가")
	private int stockPrice;
	
	@ApiModelProperty(value="현재가격")
	private int currentPrice;
	
	@ApiModelProperty(value="전일 대비 증감")
	private int plusMinus;

	public int getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getPlusMinus() {
		return plusMinus;
	}

	public void setPlusMinus(int plusMinus) {
		this.plusMinus = plusMinus;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	}