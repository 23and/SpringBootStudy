package boot.board.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan("boot.board.dao")
@EnableTransactionManagement
@EnableCaching
public class CleanBoardConfiguration {
	
	@Autowired
	private ResourcePatternResolver patternResolver;
	
	@Value("${spring.datasource.driverClassName}")
	private String databaseDriverClassName;
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	
	@Value("${spring.datasource.username}")
	private String databaseUsername;
	
	@Value("${spring.datasource.password}")
	private String databasePassword;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() throws SQLException {
		HikariConfig hikariConfig = new HikariConfig();
		
		hikariConfig.setDriverClassName(databaseDriverClassName);
		hikariConfig.setJdbcUrl(datasourceUrl);
		hikariConfig.setUsername(databaseUsername);
		hikariConfig.setPassword(databasePassword);
		
		return new HikariDataSource(hikariConfig);	
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(patternResolver.getResources(
				ResourceLoader.CLASSPATH_URL_PREFIX + "mapper/**/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	public PlatformTransactionManager transactionManager () throws SQLException {
		return new DataSourceTransactionManager(dataSource());	
	}
	
	@Bean
	public CacheManager cacheManager(){
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("cleanCache");
		return cacheManager;
	}
}