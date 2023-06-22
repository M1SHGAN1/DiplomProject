package api.Data;

import api.Models.Category;
import api.Models.PetsData;
import api.Models.Tag;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PetDataGeneration {
     public static PetsData generateDataPet(String status) {
          // Создание объекта PetsData
          PetsData petsData = new PetsData();

          // Создание объектов Category и Tag
          Category category = new Category();
          Tag tag = new Tag();

          // Генерация случайного числа типа Long
          Long rndLong = ThreadLocalRandom.current().nextLong(2030009999);

          // Заполнение полей объекта PetsData
          petsData.setId(rndLong);
          petsData.setName(RandomStringUtils.randomAlphabetic(8));
          petsData.setPhotoUrls(Arrays.asList(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(8)));

          // Заполнение полей объекта Category
          category.setId(rndLong);
          category.setName(RandomStringUtils.randomAlphabetic(8));
          petsData.setCategory(category);

          // Заполнение полей объекта Tag
          tag.setId(new Random().nextInt(2030099));
          tag.setName(RandomStringUtils.randomAlphabetic(8));
          petsData.setTags(Arrays.asList(tag));

          // Заполнение поля status объекта PetsData
          petsData.setStatus(status);

          return petsData;
     }
}