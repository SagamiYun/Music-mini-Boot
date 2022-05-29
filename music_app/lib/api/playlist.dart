import 'package:music_app/api/request_util.dart';
import 'package:music_app/model/playlist.dart';

const String prefix = '/playlists/';

Future<Playlist> detail(id) async {
  final data = await RequestUtil.get(prefix + id);
  return Playlist.fromJson(data);
}