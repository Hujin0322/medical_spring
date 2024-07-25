package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KakaoDto {

	private Long id;
	private String connected_at;
	private Properties properties;
	private Kakao_account kakao_account;
	
	@Data
	public class Properties{
		private String nickname;
		private String profile_image;
		private String thumbnail_image;
	}
	
	@Data
	public class Kakao_account{
		private Boolean profile_nickname_needs_agreement;
		private Boolean profile_image_needs_agreement;
		private Profile profile;
		private String name;
		private Boolean email_needs_agreement;
		private String email;
		private String gender;
		
		public class Profile{
			private String nickname;
			private String thumbnail_image_url;
			private String profile_image_url;
			private Boolean is_default_image;
			private Boolean is_default_nickname;
		}
	}
	
	
}
