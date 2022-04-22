
$(document).ready(function() {
let totalPages = 1;

function fetchUsers(startPage) {
    //console.log('startPage: ' +startPage);
    /**
     * get data from Backend's REST API
     */
    $.ajax({
        type : "GET",
        url : "/Admin/User/List",
        data: { 
            page: startPage, 
            size: 5
        },
        success: function(response){
          
          // add table rows
          $("#tbodyUser").replaceWith(response);


        },
        error : function(e) {
          alert("ERROR: ", e);
          console.log("ERROR: ", e);
        }
    });
}

function buildPagination(response) {
    totalPages = response.totalPages;

    var pageNumber = response.pageable.pageNumber;
    
    var numLinks = 10;
    
    // print 'previous' link only if not on page one
    var first = '';
    var prev = '';
    if (pageNumber > 0) {
        if(pageNumber !== 0) {
            first = '<li class="page-item"><a class="page-link">« First</a></li>';
        }
        prev = '<li class="page-item"><a class="page-link">« Prev</a></li>';
    } else {
        prev = ''; // on the page one, don't show 'previous' link
        first = ''; // nor 'first page' link
    }
    
    // print 'next' link only if not on the last page
    var next = '';
    var last = '';
    if (pageNumber < totalPages) {
        if(pageNumber !== totalPages - 1) {
            next = '<li class="page-item"><a class="page-link">Next »></a></li>';				
            last = '<li class="page-item"><a class="page-link">Last »</a></li>';
        }
    } else {
        next = ''; // on the last page, don't show 'next' link
        last = ''; // nor 'last page' link
    }
    
    var start = pageNumber - (pageNumber % numLinks) + 1;
    var end = start + numLinks - 1;
    end = Math.min(totalPages, end);
    var pagingLink = '';
    
    for (var i = start; i <= end; i++) {
        if (i == pageNumber + 1) {
            pagingLink += '<li class="page-item active"><a class="page-link"> ' + i + ' </a></li>'; // no need to create a link to current page
        } else {
            pagingLink += '<li class="page-item"><a class="page-link"> ' + i + ' </a></li>';
        }
    }
    
    // return the page navigation link
    pagingLink = first + prev + pagingLink + next + last;
    
    $("ul.pagination").append(pagingLink);
}

$(document).on("click", "ul.pagination li a", function() {
    var data = $(this).attr('data');
    let val = $(this).text();
    console.log('val: ' + val);

    // click on the NEXT tag
    if(val.toUpperCase() === "« FIRST") {
        let currentActive = $("li.active");
        fetchUsers(0);
        $("li.active").removeClass("active");
          // add .active to next-pagination li
          currentActive.next().addClass("active");
    } else if(val.toUpperCase() === "LAST »") {
        fetchUsers(totalPages - 1);
        $("li.active").removeClass("active");
          // add .active to next-pagination li
          currentActive.next().addClass("active");
    } else if(val.toUpperCase() === "NEXT »") {
          let activeValue = parseInt($("ul.pagination li.active").text());
          if(activeValue < totalPages){
              let currentActive = $("li.active");
            startPage = activeValue;
            fetchUsers(startPage);
              // remove .active class for the old li tag
              $("li.active").removeClass("active");
              // add .active to next-pagination li
              currentActive.next().addClass("active");
          }
      } else if(val.toUpperCase() === " PREV") {
          let activeValue = parseInt($("ul.pagination li.active").text());
          if(activeValue > 1) {
              // get the previous page
            startPage = activeValue - 2;
            fetchUsers(startPage);
              let currentActive = $("li.active");
              currentActive.removeClass("active");
              // add .active to previous-pagination li
              currentActive.prev().addClass("active");
          }
      } else {
        startPage = parseInt(val - 1);
        fetchUsers(startPage);
          // add focus to the li tag
          $("li.active").removeClass("active");
          $(this).parent().addClass("active");
        //$(this).addClass("active");
      }
});

(function(){
    fetchUsers(0);
})();
});
