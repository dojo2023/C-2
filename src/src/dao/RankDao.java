package dao;

public class RankDao {

	//ランキングの表示
	//"select   select sum(point) from posts, comments, gathers order by desc"

	//select p.名前, j.ユーザID, t.ポイント, c.ポイント, g.ポイント
	//from profiles as p
	//join posts as t on p.id = t.user_id
	//join comments as t on p.id = c.user_id
	//join gathers as t on p.id = g.user_id
	//where


	月の指定　　　　　　　　
	ユーザーの紐づけ　　　　
	ポイントの合計を出す　　select sum(point)
	降順にする　　　　　　　order by desc

}
