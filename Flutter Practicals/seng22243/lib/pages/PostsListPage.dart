import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:seng22243/models/Post.dart';

class PostsListPageWidget extends StatelessWidget {
  PostsListPageWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: PostListViewWidget(),
      // appBar: AppBar(
      //   title: Text('Posts List'),
      // ),
      // body: SafeArea(
      //     child: ListView.builder(
      //         itemCount: entries.length,
      //         itemBuilder: (BuildContext context, int index) {
      //           return Center(
      //               child: Text(
      //             '${entries[index]}',
      //             style: const TextStyle(color: Colors.green, fontSize: 20),
      //           ));
      //         })),
    );
  }
}

class PostListViewWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _PostListViewWidgetState();
  }
}

class _PostListViewWidgetState extends State<PostListViewWidget> {
  late Future<List<Post>> futurePosts;

  @override
  void initState() {
    super.initState();
    futurePosts = fetchPosts();
  }

  Future<List<Post>> fetchPosts() async {
    final response =
        await http.get(Uri.parse('https://jsonplaceholder.typicode.com/posts'));
    if (response.statusCode == 200) {
      return List<Post>.from(
          json.decode(response.body).map((data) => Post.fromJson(data)));
    } else {
      throw Exception("Failed to load Post");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: FutureBuilder<List<Post>>(
        future: futurePosts,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return ListView.builder(
                itemCount: snapshot.data?.length,
                itemBuilder: (BuildContext context, int index) {
                  return Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      children: [
                        Text(
                          '${snapshot.data![index].id}',
                          style: const TextStyle(color: Colors.green),
                        ),
                        Spacer(),
                        Text(
                          '${snapshot.data![index].title}',
                          style: const TextStyle(color: Colors.blue),
                        ),
                      ],
                    ),
                  );
                });
          } else if (snapshot.hasError) {
            return Text('${snapshot.error}');
          }

          // By default, show a loading spinner.
          return const CircularProgressIndicator();
        },
      ),
    );
  }
}

class PostViewWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _PostViewWidget();
  }
}

class _PostViewWidget extends State<PostViewWidget> {
  late Future<Post> futurePost;

  @override
  void initState() {
    super.initState();
    futurePost = fetchPosts();
  }

  Future<Post> fetchPosts() async {
    final response = await http
        .get(Uri.parse('https://jsonplaceholder.typicode.com/posts/1'));
    if (response.statusCode == 200) {
      return Post.fromJson(jsonDecode(response.body));
    } else {
      throw Exception("Failed to load Post");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Center(
        child: FutureBuilder<Post>(
          future: futurePost,
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return Text(snapshot.data!.title);
            } else if (snapshot.hasError) {
              return Text('${snapshot.error}');
            }

            // By default, show a loading spinner.
            return const CircularProgressIndicator();
          },
        ),
      ),
    );
  }
}
