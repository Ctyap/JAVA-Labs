package labs.lab7;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Class for simulating trading a single stock at varying prices.
 */
public class StockSimulator {
	private Queue<Block> Blocks = new LinkedList();
	private int profit = 0;

	public StockSimulator() {};

	public void buy(int quantity, int price){
		if (quantity < 0 || price < 0) {
			throw new IllegalArgumentException("Unable to complete purchase");
		}
		
		Block block = new Block(quantity, price);
		Blocks.add(block);
	}

	
	public int sell(int quantity, int price){
		int totalQuantity = 0;
		profit = 0;
		
		for (Block block: Blocks) {
			totalQuantity += block.getQuantity();
		}
		
		System.out.println("Total Quantity: " + totalQuantity);
		
		if (quantity > totalQuantity || quantity == 0) {
			throw new IllegalArgumentException("Unable to complete purchase");
		}
		
		
		while (quantity > 0) {
			//System.out.println("Quantity: " + quantity);
			
			//If theres enough shares in current block, calculate profit and reduce block quantity and set sell quantity to 0.
			if (Blocks.peek().getQuantity() > quantity) {
				profit += price * quantity - Blocks.peek().getPrice()*quantity;
				Blocks.peek().sell(quantity);
				quantity = 0;
				
			}else {
				//If theres not enough shares, calculate profit, reduce new sell quantity and remove the block and move onto next one.
                profit += price*Blocks.peek().getQuantity() - Blocks.peek().getPrice()*Blocks.peek().getQuantity();
                quantity -= Blocks.poll().getQuantity();
			}
		}
		
		return profit;
	}

	
	public List<Block> getBlocks() {
		return (List<Block>) Blocks;
	}
	
	public static void main(String[] args) {
		/*
		StockSimulator sim = new StockSimulator();
		sim.buy(100, 12);
		sim.buy(100, 10);
		System.out.println(sim.sell(150, 15));
		System.out.println(sim.sell(50, 15));

		
		System.out.println(sim.getBlocks());
	*/
	}
}
