<table>
   <tr>
      <td style = "background-color: orange;">
         <p class = "big" style = "color: white; font-size: 3em; 
            font-weight: bold;">

            <%-- script to determine client local and --%>
            <%-- format date accordingly              --%>
            <% 
               // get client locale
               java.util.Locale locale = request.getLocale();

               // get DateFormat for client's Locale
               java.text.DateFormat dateFormat = 
                  java.text.DateFormat.getDateTimeInstance(
                     java.text.DateFormat.LONG,
                     java.text.DateFormat.LONG, locale );

            %>  <%-- end script --%>

            <%-- output date --%>
            <%= dateFormat.format( new java.util.Date() ) %>
         </p> 
      </td>
   </tr>
</table>