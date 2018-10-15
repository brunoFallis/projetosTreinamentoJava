package br.com.cast.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cast.controllers.LoginController;
import br.com.cast.dto.PostDTO;
import br.com.cast.entities.Post;
import br.com.cast.persistence.PostDAO;
import br.com.cast.persistence.UserDAO;

public class PostBusiness {

	private PostDAO postDAO;
	private UserDAO userDAO;

	public PostBusiness() {
		this.postDAO = new PostDAO();
		this.userDAO = new UserDAO();
	}

	public List<PostDTO> bringAllPosts() {
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().
								getExternalContext().getSession(true);
		
		Integer id = ((LoginController)session.getAttribute("user")).getUserDTO().getId();
		
		List<PostDTO> postsDTO = new ArrayList<>();

		for (Post p : this.postDAO.postsByUser(id)) {
			PostDTO dto = new PostDTO();
			dto.setId(p.getId());
			dto.setTitle(p.getTitle());
			dto.setText(p.getText());
			dto.setIdUser(p.getUser().getId());
			postsDTO.add(dto);
		}

		return postsDTO;
	}
	
	public boolean insertPost(PostDTO postDTO, Integer id) {
		Post post = new Post();
		
		post.setTitle(postDTO.getTitle());
		post.setText(postDTO.getText());
		post.setUser(this.userDAO.searchById(id));
		
		if(this.postDAO.insertPost(post)) {
			return true;
		}
		System.out.println("POST ALREADY EXIST");
		return false;
	}

	public boolean deletePost(Integer id) {
		if(this.postDAO.deletePostById(id)) {
			return true;
		}
		return false;
	}

}
