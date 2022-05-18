import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:music_app/pages/home/header.dart';

import 'musician_banner.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        resizeToAvoidBottomInset: false,
        body: Column(
          children: const <Widget>[
            Header(),
            SizedBox(
              height: 40,
            ),
            MusicianBanner(
              title: "热榜音乐人",
            )
          ],
        ));
  }
}