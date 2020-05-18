
/* global APP, DISPLAY */

var REST =
        {

            loadpage: function (page, forw)
            {
                if (page !== null)
                    APP.page = page;

                if (forw !== null)
                    if (forw)
                        APP.page += 1;
                    else
                        APP.page -= 1;

                if (APP.page < 0)
                    APP.page = 0;

                var p = parse(APP.page);
                var s = parseInt(APP.pagesize);

            },

            loadpost: function (id)
            {
                $.get('/rest/post/' + id, function (data)
                {
                    DISPLAY.displayPost(data);
                });

                $.get('/rest/post/' + id + '/comments', function (data)
                {
                    DISPLAY.displayComments(data);
                });
            },

            submituser: function ()
            {
                var name = $('#c_username').val();
                var mail = $('#c_email').val();

                $.ajax
                        ({
                            async: false,
                            url: "/rest/user",
                            type: "POST",
                            data: JSON.stringify({username: name, email: mail}),
                            contentType: "application/json",
                            success: function ()
                            {
                                alert("New User created!");
                            }
                        });
            },

            submitpost: function ()
            {
                var name = $('#c_username').val();
                var title = $('#c_title').val();
                var content = $('#c_content').val();


                if (title === "")
                    title = "no title";

                $.ajax
                        ({
                            url: "/rest/post?from=" + name,
                            type: "POST",
                            data: JSON.stringify({title: title, content: content}),
                            contentType: "application/json",
                            success: function ()
                            {
                                alert("New Post created!");
                            }
                        });
            },

            submitcomment: function ()
            {
            }

        };