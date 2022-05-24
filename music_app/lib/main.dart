import 'package:flutter/material.dart';

import 'package:music_app/pages/home/home_page.dart';
import 'package:music_app/pages/login/login_page.dart';
import 'package:music_app/pages/playlist/detail_page.dart';
import 'package:music_app/theme.dart';

void main() {
  runApp(const SaKaTiMusic());
}

class SaKaTiMusic extends StatelessWidget {


const SaKaTiMusic({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'SaKaTiMusic',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(primarySwatch: primary, tabBarTheme: tabBarTheme),
    initialRoute: '/',
    routes: {
      '/': (context) => const HomePage(),
      '/login': (context) => const LoginPage(),
      '/playlist/detail': (context) => const PlaylistDetailPage()
    },
    );
  }

}
