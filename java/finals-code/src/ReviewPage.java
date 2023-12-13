//review page that holds all the reviews

import java.util.ArrayList;

public class ReviewPage {
	private ArrayList<Review> reviews = new ArrayList<Review>();
	
	public ReviewPage(){
		
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	public void printReviews() {
		int count = 1;
		for (Review r: reviews) {
			System.out.printf("Review %d:\n", count);
			System.out.println(r);
			count ++;
		}
	}
}
