
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

   
  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->
  
<!--  content -->
   <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
   <img src="${pageContext.request.contextPath}/view/client/assets/images/contact-banner.png" alt="banner liên hệ">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Liên hệ</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>         
          <li style="color:#fff">Thông tin liên hệ</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->
<!-- start contact section -->
 <section id="aa-contact">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="aa-contact-area">
           <div class="aa-contact-top">
             <h2>Chúng tôi đang chờ để hỗ trợ bạn..</h2>
             <p>Nếu bạn nó bất cứ thắc mắc hay ý kiến gì cứ tìm đến chúng tôi.</p>
           </div>
         
           <!-- Contact address -->
           <div class="aa-contact-address">
             <div class="row">
               <div class="col-md-7">
         			 <div class="aa-contact-map">
              <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d4273.422114668379!2d106.7700669849596!3d10.851505720933718!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317527756a955555%3A0x6f97a3b38adf8326!2zS2h1IEEgVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBzxrAgcGjhuqFtIGvhu7kgdGh14bqtdCBUUC4gSENN!5e0!3m2!1svi!2s!4v1610902849713!5m2!1svi!2s" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
           </div>
               </div>
               <div class="col-md-5">
                 <div class="aa-contact-address-right">
                   <address>
                     <h4>Nông Sản 24h</h4>
                     <p>Liên hệ cho chúng tôi bất cứ khi nào bạn cần.</p>
                     <p><span class="fa fa-home"></span>Số 1, Linh Chiểu, Thủ Đức, TP.HCM</p>
                     <p><span class="fa fa-phone"></span>092.396.7050</p>
                     <p><span class="fa fa-envelope"></span>Email: namkhoapham@gmail.com</p>
                   </address>
                 </div>
               </div>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>
 </section>
<!--  end content-->
  
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->


  
