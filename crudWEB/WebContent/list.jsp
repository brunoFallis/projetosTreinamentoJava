<%@page import="br.com.cast.persistence.ContactDAO"%>
<%@page import="br.com.cast.models.Contact"%>
<%@page import="java.util.*"%>
<%
  ContactDAO cDao = new ContactDAO();
  List<Contact> listContacts = cDao.listContacts();  
%>

<table>
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Adress</th>
		<th>Date of Birth</th>
		<th>Actions</th>
	</tr>
	<%for(Contact c : listContacts) {%>
	<tr>
		<td><%=c.getName()%></td>
		<td><%=c.getEmail()%></td>
		<td><%=c.getAdress()%></td>
		<td><%=c.getDateBirth()%></td>
		<td>
			<button id="btn-excluir" type="submit" value="<%=c.getId()%>">
				Excluir
			</button>
			<button id="btn-alterar" type="submit" value="<%=c.getId()%>">
				Alterar
			</button>
		</td>
	</tr>
	<%};%>
</table>