package potato.domain;

import java.sql.Date;
import java.util.Arrays;

public class DetailedReviewDomain {

	private String id, contents, nick, img;
	private String[] foodimg;
	private int review_idx, rating, likeTotal, liked;
	private Date post_date;
	
	public DetailedReviewDomain() {
		super();
	}

	public DetailedReviewDomain(String id, String contents, String nick, String img, String[] foodimg, int review_idx,
			int rating, int likeTotal, int liked, Date post_date) {
		super();
		this.id = id;
		this.contents = contents;
		this.nick = nick;
		this.img = img;
		this.foodimg = foodimg;
		this.review_idx = review_idx;
		this.rating = rating;
		this.likeTotal = likeTotal;
		this.liked = liked;
		this.post_date = post_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String[] getFoodimg() {
		return foodimg;
	}

	public void setFoodimg(String[] foodimg) {
		this.foodimg = foodimg;
	}

	public int getReview_idx() {
		return review_idx;
	}

	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getLikeTotal() {
		return likeTotal;
	}

	public void setLikeTotal(int likeTotal) {
		this.likeTotal = likeTotal;
	}

	public int getLiked() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	@Override
	public String toString() {
		return "DetailedReviewDomain [id=" + id + ", contents=" + contents + ", nick=" + nick + ", img=" + img
				+ ", foodimg=" + Arrays.toString(foodimg) + ", review_idx=" + review_idx + ", rating=" + rating
				+ ", likeTotal=" + likeTotal + ", liked=" + liked + ", post_date=" + post_date + "]";
	}
	
}
