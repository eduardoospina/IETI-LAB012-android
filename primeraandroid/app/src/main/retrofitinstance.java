public class retrofitinstance {
    Gson gson = new GsonBuilder().setDateFormat( "yyyy-MM-dd'T'HH:mm:ss" ).create();

    Retrofit.Builder builder = new Retrofit.Builder().baseUrl( BuildConfig.API_BASE_URL ).addConverterFactory( GsonConverterFactory.create( gson ) ).addCallAdapterFactory( RxJavaCallAdapterFactory.createWithScheduler( Schedulers.io() ) );

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(); loggingInterceptor.setLevel( HttpLoggingInterceptor.Level.BODY );

    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor( loggingInterceptor ) .addInterceptor(new AuthInterceptor(storage)) .writeTimeout( 0, TimeUnit.MILLISECONDS ).readTimeout( 2, TimeUnit.MINUTES ).connectTimeout( 1, TimeUnit.MINUTES ).build(); return builder.client( okHttpClient ).build();`
}
