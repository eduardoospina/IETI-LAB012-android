@Module
@InstallIn(SingletonComponent.class)
class AnalyticsModule {
    @Provides
    public AnalyticsService provideAnalyticsService() {
        return GoogleAnalyticsService()
    }
}

    @Inject
    AnalyticsService analyticsService;