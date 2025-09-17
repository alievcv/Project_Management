package tenzor.soft.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tenzor.soft.test.dto.ProjectStatusCountDto;
import tenzor.soft.test.dto.dashboard.*;
import tenzor.soft.test.entity.Project;

import java.util.List;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Long> {

    Page<Project> findAll(Pageable pageable);

    @Query("""
               SELECT new tenzor.soft.test.dto.ProjectStatusCountDto(
                   p.status,
                   COUNT(p)
               )
               FROM Project p
               GROUP BY p.status
            """)
    List<ProjectStatusCountDto> countProjectsGroupedByStatus();


    @Query(value = """
            SELECT
                TRIM(TO_CHAR(from_date, 'Month')) AS month_name,
                SUM(revenue)::bigint AS total_revenue
            FROM project
            WHERE EXTRACT(YEAR FROM from_date) = :year
            GROUP BY TO_CHAR(from_date, 'Month'), EXTRACT(MONTH FROM from_date)
            ORDER BY EXTRACT(MONTH FROM from_date)
            """, nativeQuery = true)
    List<MonthlySalesRevenueResponseDto> getMonthlySalesRevenue(@Param("year") Long year);

    @Query(value = """

            SELECT
                c.name AS type,
                ROUND( (SUM(p.revenue)::numeric
                    / (SELECT SUM(p2.revenue)
                       FROM project p2 WHERE EXTRACT(YEAR FROM from_date) = :year )) * 100 )::bigint AS revenue
            FROM project p
            JOIN Category c ON p.category_id = c.id
            WHERE EXTRACT(YEAR FROM from_date) = :year
            GROUP BY c.name""", nativeQuery = true)
    List<RevenueByProjectType> getRevenuePercentagesByProjectType(@Param("year") Long year);


    @Query(value = """
                SELECT p.name as siname, c.name AS sitype
                from Project p
                left join Category c on p.category_id = c.id
                where c.name = 'SI' and  EXTRACT(YEAR FROM from_date) = :year
                ORDER BY p.revenue DESC
                LIMIT 4;
            """, nativeQuery = true)
    List<SICategoryTopFourProjects> getTopFourFromSICategory(@Param("year") Long year);

    @Query(value = """
                SELECT p.name as smname, c.name AS smtype
                from Project p
                left join Category c on p.category_id = c.id
                where c.name = 'SM' and  EXTRACT(YEAR FROM from_date) = :year
                ORDER BY p.revenue DESC
                LIMIT 4;
            """, nativeQuery = true)
    List<SMCategoryTopFourProjects> getTopFourFromSMCategory(@Param("year") Long year);

    @Query(value = """

            SELECT
        COALESCE(SUM(p.revenue),0)::bigint AS total_revenue,
        :goal AS annual_goal,
        ROUND( (COALESCE(SUM(p.revenue),0) / NULLIF(:goal,0)) * 100 )::bigint AS achieved_percent,
        (:goal - COALESCE(SUM(p.revenue),0))::bigint AS remaining_revenue
    FROM project p
    WHERE EXTRACT(YEAR FROM p.from_date) = :year;
    
    """, nativeQuery = true)
    KeyPerformanceIndicatorResponseDto getKPIDashboard(@Param("year") Long year, @Param("goal") Long goal);
}
