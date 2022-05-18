import 'package:flutter/material.dart';

import '../widget/header.dart';

class Home extends StatelessWidget {
  const Home({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Column(
          children: <Widget>[
            Header(),
            ElevatedButton(onPressed: () {
              Navigator.pushNamed(context, '/login');
            }, child: Text("登录"),)
          ],
        )
    );
  }
}