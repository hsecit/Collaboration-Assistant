$(function () {
    $("#stdMeetingsGrid").jsGrid({								//!
    	
        height: "90%",
        width: "100%",
        
    	
        filtering: true,
        editing: false,
        sorting: true,
        paging: false,
        autoload: true,

        controller: {
            loadData: function () {
                var deferred = $.Deferred();
                $.ajax({									//GET
                    url: '/CA-Project/student/api/team/'+teamId+'/meetings',				// !
                    dataType: 'json'
                }).done(function (data) {
                    deferred.resolve(data);
                }).fail(function () {
                    WebUtils.show('Error to load data');
                    deferred.reject("loading error");
                });
                return deferred.promise();
            },

           

        },
        fields: [														//!!
        			// from DB
            {name: "title", type: "text", title: "Title", validate: "required"},
            {name: "address", type: "text",  title: "address"},
            {name: "datetime", type: "jsDate", width: 150, title: "Date", validate: "required"},
            {type: "control", editButton: false, deleteButton: false, modeSwitchButton: false, clearFilterButton: true}

        ]

    });
   
});
